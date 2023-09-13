package com.lvezcl;



import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ServletTest extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");

        int intNum1=parseInt(num1,0);
        int intNum2=parseInt(num2,0);
        int res=intNum1+intNum2;

        PrintWriter writer = response.getWriter();
        writer.print("<h1>"+intNum1+"+"+intNum2+"="+res+"<h1>");

        writer.flush();
        writer.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public int parseInt(String num1, int defaultVal) {

        try {
            return Integer.parseInt(num1);
        } catch (NumberFormatException e) {
            System.out.println(num1+"格式不对，转换失败");
        }
        return defaultVal;
    }
}