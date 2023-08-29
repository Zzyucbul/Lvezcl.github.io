package com.sjziei.shopManage.career;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class shopService {
			
	@Autowired 
	private shopDAO dao;
	
	public String register(shopInfo s) {
		boolean exist=dao.isExistUser(s.getUserName());
		if(exist) {
			return "用户名已存在，请重新输入";
		}else {
				boolean insert=dao.insert(s);
				String res=insert ?"注册成功" :"注册失败";
				return res;
		}
	}
	
}
