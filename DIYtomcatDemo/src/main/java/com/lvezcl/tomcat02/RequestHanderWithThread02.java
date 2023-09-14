package com.lvezcl.tomcat02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RequestHanderWithThread02 {
    public static void main(String[] args) throws IOException {
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
