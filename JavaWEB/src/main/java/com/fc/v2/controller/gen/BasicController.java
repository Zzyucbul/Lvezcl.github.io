package com.fc.v2.controller.gen;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
@RequestMapping("/BasicController")
public class BasicController {
	private String prefix = "gen/basic";
	@GetMapping("/editphone/{id}")
    public String editPhone(@PathVariable("id") String id, ModelMap map)
    {
		
		
        return prefix + "/editphone";
    }
	@GetMapping("/editpassword/{id}")
    public String editPassWord(@PathVariable("id") String id, ModelMap map)
    {
       

        return prefix + "/editpassword";
    }
	
}
