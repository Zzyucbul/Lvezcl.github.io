package com.lvezcl.tomcat03.http;

import java.io.OutputStream;

/**
 *
 *
 * lxfResponse对象可以封装OutputStream(是socket关联)
 * 即可以通过HspResponse对象返回Http响应给浏览器/客户端
 * lxfResponse对象的作用等价于原生的servlet.的HttpServletResponse
 * */
public class lxfResponse  {

    private OutputStream outputStream=null;

    //写一个响应头
    public  static final String respHeader="HTTP/1.1  200  OK\r\n"+
            "Content-type:text/html;charset=utf-8\r\n\r\n";

    public lxfResponse(OutputStream outputStream){
        this.outputStream=outputStream;
    }

    //参考ServletTest中返回数据的操作，这里应该写一个输出流，通过lxfResponse来完成数据返回
    public OutputStream getOutputStream(){
        return outputStream;
    }
}
