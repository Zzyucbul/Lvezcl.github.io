package com.fc.v2.controller.gen;

import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.model.auto.Class;
import com.fc.v2.service.ClassService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Controller
 * @ClassName: ClassController
 * @author fuce
 * @date 2023-11-21 10:23:24
 */
@Api(value = "")
@Controller
@RequestMapping("/ClassController")
public class ClassController extends BaseController{
	
	private String prefix = "gen/class";
	
	@Autowired
	private ClassService classService;
	
	
	/**
	 * 页面展示
	 * @param model
	 * @return String
	 * @author fuce
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:class:view")
    public String view(ModelMap model)
    {
        return prefix + "/list";
    }
	
	/**
	 * list集合
	 * @param tablepar
	 * @param searchText
	 * @return
	 */
	//@Log(title = "", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:class:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,Class t_class){
		PageInfo<Class> page=classService.list(tablepar,t_class);
		return pageTable(page.getList(),page.getTotal());
	}
	

	
	
    
	
}
