package com.lvezcl.tomcat03.tomcat02;

import com.lvezcl.tomcat03.http.lxfRequest;
import com.lvezcl.tomcat03.http.lxfResponse;
import com.lvezcl.tomcat03.lxfTomcat03;
import com.lvezcl.tomcat03.servlet.lxfHttpServlet;
import com.lvezcl.tomcat03.utils.webUtils;

import java.io.*;
import java.net.Socket;

public class RequestHanderWithThread  implements  Runnable{

    private Socket socket=null;

    public RequestHanderWithThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
//            InputStream inputStream = socket.getInputStream();
            //将字节输入流转换为字符流主要是为了能一行一行的读取数据
            lxfRequest request = new lxfRequest(socket.getInputStream());
//            String parameter1 = request.getParameter("num1");
//            String parameter2 = request.getParameter("num2");
//            System.out.println("得到的参数1："+parameter1);
//            System.out.println("得到的参数2："+parameter2);
//            System.out.println(request);

            lxfResponse response=new lxfResponse(socket.getOutputStream());
//            String responseContent = lxfResponse.respHeader + "<h1> hi 这是lxfResponse发来的数据</h1>";

            String url = request.getUrl();
            //(1)获取到url后，我们要判断url是什么资源。
            //(2)如果是静态资源，就读取该资源，并返回给浏览器 conten-type text/html
            //(3)因为这是我们自己写的tomcat，不是一个标准的web项目
            //(4)要自己吧读取的资源放到target/classes下
            if(webUtils.isHtml(url)){
                String content = webUtils.readFile(url.substring(1));
                //使用响应头+内容就会被浏览器解析
                String respHeader=lxfResponse.respHeader+content;
               // System.out.println(respHeader);
                //通过socket的outputStream输出内容。
                OutputStream outputStream=response.getOutputStream();
                outputStream.write(respHeader.getBytes());
                outputStream.flush();
                outputStream.close();
                socket.close();
                return;
            }

            //在这里报空指针异常，是因为ConcurrentHashMap的原因，她不能为空，会报异常。可以换为hashMap
            String servletName = lxfTomcat03.servletUrlMapping.get(url);
            if(servletName != null){
                //使用了多态。lxfHttpServlet是MainServlet的子类
                //预防别人瞎写了一个url，我们要判断一下
                lxfHttpServlet lxfHttpServlet = lxfTomcat03.servletMapping.get(servletName);
                if (lxfHttpServlet != null){
                    lxfHttpServlet.service(request,response);
                }else{
                    //没有servlet,返回404
                    String retu = lxfResponse.respHeader + "<h1> 404 not found</h1>";
                    OutputStream outputStream = response.getOutputStream();
                    outputStream.write(retu.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }
            }


            //此处完成了闭环。
            //调用lxfHttpServlet，去判断是get方法，然后动态绑定到MainServlet执行他的doGet方法。


//            //此处与上上行代码并不冲突。因为我的lxfResponse对象是要传给servlet使用，可在servletTest中查看
//            OutputStream outputStream = response.getOutputStream();
//            outputStream.write(responseContent.getBytes());
//            outputStream.flush();
//            outputStream.close();

//            String resHeader="HTTP/1.1  200  OK\r\n"+
//                    "Content-type:text/html;charset=utf-8\r\n\r\n";
//            //返回的响应头和响应体之间有两个换行
//            String resp=resHeader+"<h1>你好，张三</h1>";
//            System.out.println("=========返回的数据为=========");
//            System.out.println(resp);
//            OutputStream outputStream = socket.getOutputStream();
//            outputStream.write(resp.getBytes());
//            outputStream.flush();
//            outputStream.close();;
//            socket.getOutputStream().close();

            //socket关了，别的input等也就关了
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //socket一定要关闭，不然会造成阻塞
            if(!socket.isClosed()){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
