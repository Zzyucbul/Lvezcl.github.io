package com.lvezcl.tomcat02;

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
            InputStream inputStream = socket.getInputStream();
            //将字节输入流转换为字符流主要是为了能一行一行的读取数据
            BufferedReader buf=new BufferedReader(new InputStreamReader(inputStream,"utf-8")) ;

            System.out.println("=========接收到客户端发来的数据如下===========");

            String mes=null;
            while( (mes=buf.readLine()) != null){
                if(mes.isEmpty()){
                    break;  //如果读到了“”  空字符就要结束
                }
                System.out.println(mes);
            }


            String resHeader="HTTP/1.1  200  OK\r\n"+
                    "Content-type:text/html;charset=utf-8\r\n\r\n";
            //返回的响应头和响应体之间有两个换行
            String resp=resHeader+"<h1>你好，张三</h1>";


            System.out.println("=========返回的数据为=========");
            System.out.println(resp);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(resp.getBytes());
            outputStream.flush();
            outputStream.close();;
            inputStream.close();
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
