package com.lvezcl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        System.out.println("服务端在8080端口监听。。。");


        while( !serverSocket.isClosed()){
            //当有人请求8080端口生成socket对象
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();

            BufferedReader buf=new BufferedReader(new InputStreamReader(inputStream,"utf-8"));

            String mes=null;
           // System.out.println("接收到客户端发来的数据");
            while( (mes=buf.readLine()) != null){
                if(mes.isEmpty()){
                    break;
                }
                System.out.println(mes);
            }

            String resHeader="HTTP/1.1 200 OK\r\n"+
                    "Content-type: text/html;charset=utf-8\r\n\r\n";
            String resp=resHeader+"hello，李晓锋";

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(resp.getBytes());
            System.out.println("接收到的数据如下：");
            System.out.println(resp);

            outputStream.flush();
            outputStream.close();
            inputStream.close();
            socket.close();
        }


    }
}
