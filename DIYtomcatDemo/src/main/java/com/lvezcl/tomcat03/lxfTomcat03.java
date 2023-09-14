package com.lvezcl.tomcat03;

import com.lvezcl.tomcat03.servlet.MainServlet;
import com.lvezcl.tomcat03.servlet.lxfHttpServlet;
import com.lvezcl.tomcat03.tomcat02.RequestHanderWithThread;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class lxfTomcat03 {
    public static final ConcurrentHashMap<String, lxfHttpServlet> servletMapping=new ConcurrentHashMap<>();

    public static final ConcurrentHashMap<String,String> servletUrlMapping=new ConcurrentHashMap<>();

/**
 * tomcat容器底层机制，肯定要读取xml文件，存入两个hashmap
 * */
    public void init() throws Exception {
        String path=lxfTomcat03.class.getResource("/").getPath();
        System.out.println("path="+path);

        SAXReader saxReader=new SAXReader();

            Document document = saxReader.read(new File(path + "web.xml"));
            //System.out.println("document="+read);

            //获取根元素
            Element rootElement = document.getRootElement();
            //获取根元素下的所有元素
            List<Element> elements = rootElement.elements();
            for (Element e :elements){
                if("servlet".equalsIgnoreCase(e.getName())){
                    Element servletName = e.element("servlet-name");
                    Element servletClass = e.element("servlet-class");
                    if (servletName != null && servletClass != null) {
                        // 执行相关操作
                        servletMapping.put(servletName.getText(),(lxfHttpServlet) Class.forName(servletClass.getText().trim()).newInstance());
                    }else{
                        // 添加日志记录或错误处理
                        System.err.println("Error: Missing servlet-name or servlet-class element in servlet configuration.");
                    }

                } else if ("servlet-mapping".equalsIgnoreCase(e.getName())) {
                    Element servletName = e.element("servlet-name");
                    Element urlPattern = e.element("url-pattern");
                    if (servletName != null && urlPattern != null) {
                        // 执行相关操作

                        //这里应该是将urlPattern设置为key，Name设置为value;
                        //因为我们得到请求地址后，根据你发送来的/MainServlet去寻找对应的servletMapping
                        //再根据servletMapping的值（MainServlet）去寻找对应的servlet-class。
                        servletUrlMapping.put(urlPattern.getText(),servletName.getText());
                    }else{
                        // 添加日志记录或错误处理
                        System.err.println("Error: Missing servlet-name or servlet-class element in servlet configuration.");
                    }


                }
            }

    }

    public static void main(String[] args) throws Exception {
        lxfTomcat03 l=new lxfTomcat03();
        l.init();
        System.out.println("servletMapping"+servletMapping);
        System.out.println("servletUrlMapping"+servletUrlMapping);
        l.run();
    }
    public   void run() throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        System.out.println("=======8080监听中=======");

        //只要serverSocket没有关闭就会一直等待客户端/浏览器连接
        while(!serverSocket.isClosed()){
            Socket socket = serverSocket.accept();

            //实现Runnable接口方式更适合多个线程共享一个资源的情况
            new Thread(new RequestHanderWithThread(socket)).start();
        }
    }

}
