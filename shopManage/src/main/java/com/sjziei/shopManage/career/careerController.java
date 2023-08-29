package com.sjziei.shopManage.career;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 如果要求方法返回的是json格式数据，
 * 而不是跳转页面，可以直接在类上标注@RestController，
 * 而不用在每个方法中标注@ResponseBody
 * @author 18496
 *
 */
@Controller
@RequestMapping("/user")
public class careerController {
	
	@Autowired
	private shopService service;
	@RequestMapping("shopRegister")
	public String  shopRegister() {
		System.out.println("a");
		return  "redirect:/html/register.html";
	}
	
	
	@RequestMapping("register")	
		@ResponseBody
		public String register(@RequestParam("username")String username,
				@RequestParam("password")String password,
				@RequestParam("email")String email) {
		shopInfo s=new shopInfo();
		s.setUserName(username);
		s.setPassword(password);
		s.setEmail(email);
		return  service.register(s);
	}
}
