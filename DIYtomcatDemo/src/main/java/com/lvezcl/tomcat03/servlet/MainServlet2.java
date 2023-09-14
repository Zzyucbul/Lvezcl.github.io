package com.lvezcl.tomcat03.servlet;

import com.lvezcl.tomcat03.http.lxfRequest;
import com.lvezcl.tomcat03.http.lxfResponse;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import com.lvezcl.tomcat03.utils.webUtils;

public class MainServlet2 extends lxfHttpServlet{

    @Override
    public void doGet(lxfRequest lxfRequest, lxfResponse lxfResponse) {
        //java基础的 OOP动态绑定机制
        String num1 = lxfRequest.getParameter("num1");
        String num2 = lxfRequest.getParameter("num2");

        int intNum1= webUtils.parseInt(num1,0);
        int intNum2= webUtils.parseInt(num2,0);
        int res=intNum1*intNum2;

        OutputStream outputStream = lxfResponse.getOutputStream();
        String respContent=lxfResponse.respHeader+"<h1>"+num1+"*"+num2+"="+res+" hi ,张三,反射+xml创建</h1>";
        try {
            outputStream.write(respContent.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(lxfRequest lxfRequest, lxfResponse lxfResponse) {
        this.doGet(lxfRequest,lxfResponse);
    }

    @Override
    public void init(ServletConfig var1) throws ServletException {

    }

    @Override
    public void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}
