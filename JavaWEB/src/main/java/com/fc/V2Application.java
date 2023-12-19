package com.fc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.fc.v2.model.master;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages = "com.fc.v2")
public class V2Application {

    public static void main(String[] args) {
    	
    	ConfigurableApplicationContext ioc = SpringApplication.run(V2Application.class, args);
        System.out.println("*******************************************\n" +
        		"* 码云地址                                  *\n" +
        		"* https://gitee.com/bdj/SpringBoot_v2     *\n" +
        		"*                                         *\n" +
        		"*******************************************\n" +
        		"           _.._        ,-------------------.\n" +
        		"        ,'      `.    ( 启动成功！开启学习之旅！      )\n" +
        		"       /  __) __` \\    `-,-----------------'\n" +
        		"      (  (`-`(-')  ) _.-'\n" +
        		"      /)  \\  = /  (\n" +
        		"     /'    |--' .  \\\n" +
        		"    (  ,---|  `-.)__`\n" +
        		"     )(  `-.,--'   _`-.\n" +
        		"    '/,'          (  Uu\",\n" +
        		"     (_       ,    `/,-' )\n" +
        		"     `.__,  : `-'/  /`--'\n" +
        		"       |     `--'  |\n" +
        		"       `   `-._   /\n" +
        		"        \\        (\n" +
        		"        /\\ .      \\. \n" +
        		"       / |` \\     ,-\\\n" +
        		"      /  \\| .)   /   \\\n" +
        		"     ( ,'|\\    ,'     :\n" +
        		"     | \\,`.`--\"/      }\n" +
        		"     `,'    \\  |,'    /\n" +
        		"    / \"-._   `-/      |\n" +
        		"    \"-.   \"-.,'|     ;\n" +
        		"   /        _/[\"---'\"\"]\n" +
        		"  :        /  |\"-     '\n" +
        		"  '           |      /\n" +
        		"              `      |");

        
        //使用configuration注解向容器添加bean，类似于在配置文件中添加bean
       // master bean01 = ioc.getBean("beanMaster",master.class);
//        master bean01 = ioc.getBean("xiongda",master.class);
//        System.out.println("masterBean01="+bean01);

    }
    

}
