package com.fc.v2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fc.v2.model.master;

@Configuration
public class beanConfig {

	
	//这个bean的默认id就是他的类名，也可以使用name修改
	@Bean(name="xiongda")
	public master beanMaster() {
		return new master("熊大","棕色","咆哮");
	}
}
