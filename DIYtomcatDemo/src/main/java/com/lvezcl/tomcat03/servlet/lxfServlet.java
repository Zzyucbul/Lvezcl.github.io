package com.lvezcl.tomcat03.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public interface lxfServlet {
    void init(ServletConfig var1) throws ServletException;

    void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;

    void destroy();


}
