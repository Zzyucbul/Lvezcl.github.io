package com.lvezcl.tomcat03.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class webUtils {
    public static int parseInt(String num1, int defaultVal) {

        try {
            return Integer.parseInt(num1);
        } catch (NumberFormatException e) {
            System.out.println(num1+"格式不对，转换失败");
        }
        return defaultVal;
    }

    public static boolean isHtml(String content){
        return content.endsWith(".html");
    }
    public static String readFile(String fileName){
        String path=webUtils.class.getResource("/").getPath();
        StringBuilder s=new StringBuilder();
        String res="";
        try {
            BufferedReader buf=new BufferedReader(new FileReader(path+fileName));
            while((res= buf.readLine()) != null){
                s.append(res);
            }
            buf.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return s.toString();
    }
}
