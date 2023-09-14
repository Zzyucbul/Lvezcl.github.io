package com.lvezcl.tomcat03.servlet;

import com.lvezcl.tomcat03.http.lxfRequest;
import com.lvezcl.tomcat03.http.lxfResponse;

import java.io.IOException;

public abstract  class lxfHttpServlet implements lxfServlet{

    public void service(lxfRequest lxfRequest, lxfResponse lxfResponse){
        if("GET".equalsIgnoreCase(lxfRequest.getMethod())){
            this.doGet(lxfRequest,lxfResponse);
        }else if("POST".equalsIgnoreCase(lxfRequest.getMethod())){
            this.doPost(lxfRequest,lxfResponse);
        }

    }

    //这里使用了模板设计模式
    //让lxfHttpServlet子类 MainServlet实现
    public abstract  void doGet(lxfRequest lxfRequest, lxfResponse lxfResponse) ;
    public abstract  void doPost(lxfRequest lxfRequest, lxfResponse lxfResponse) ;

}
