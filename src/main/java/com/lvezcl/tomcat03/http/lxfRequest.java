package com.lvezcl.tomcat03.http;

import java.io.*;
import java.util.HashMap;

/** 浏览器发送请求到tomcat，tomcat会把请求相关数据封装为httpServletRequest对象和response

 *lxfRequest封装http请求的数据,相当于原生的httpServletRequest
 *如，方法（get、post）、参数列表、url。此类考虑get方法
 *
 * http包下的两个类作为与客户端交互
 */



public class lxfRequest {

    private String method;
    private String url;
    private InputStream inputStream=null;
    //inputStream要设置为成员变量。才会被所有方法持有。


    //存放参数列表， 参数名-参数值-》hashMap
    private HashMap <String,String> parameterMapping=new  HashMap<>();

    //构造器 =>对http请求进行封装
    //inputStream是和 对应http请求对应的socket关联
    public lxfRequest (InputStream inputStream){
        this.inputStream=inputStream;
        encapHttpRequest();
    }

    //encapsulation  封装
    //封装http请求的相关数据进行封装，然后提供相关的方法，进行获取
    private void encapHttpRequest( ){
       // System.out.println("lxfRequest init..");
        try {
            BufferedReader buf=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));

            //GET /DIYtomcatDemo/ServletTest?num1=30&num2=20 HTTP/1.1
            String requestLine=buf.readLine();
            String[] requestLineArray = requestLine.split(" ");
            //取得get方法
            method=requestLineArray[0];

            //取url
            int index=requestLineArray[1].indexOf("?");
            if(index == -1){
                url=requestLineArray[1];
            }else{
                //substring是获得String的子字符串，推荐使用substring
                url = requestLineArray[1].substring(0, index);


                //获取参数列表num1=30&num2=20
                String parameters = requestLineArray[1].substring(index+1);
                //分割得到数组  （"num1=30","num2=20"）
                String[] parametersPair = parameters.split("&");

                //防止用户提交时是/DIYtomcatDemo/ServletTest?  ，这样我们获得的就是空
                if(null !=parametersPair && !"".equals(parametersPair) ) {
                    //循环拿出parametersPair的参数
                    for(String parameterPair :parametersPair){
                        String[] paraAndValue = parameterPair.split("=");
                        if(paraAndValue.length == 2){
                            parameterMapping.put(paraAndValue[0],paraAndValue[1]);
                        }
                    }
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getParameter(String name){
        if(parameterMapping.containsKey(name)){
            return parameterMapping.get(name);
        }else{
            return "";
        }
    }

    @Override
    public String toString() {
        return "lxfRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", parameterMapping=" + parameterMapping +
                '}';
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
