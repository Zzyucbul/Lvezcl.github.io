package com.fc.v2.controller.gen;

import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.auto.*;
import com.fc.v2.model.auto.Class;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.service.ClassService;
import com.fc.v2.service.DepartService;
import com.fc.v2.service.MajorService;
import com.fc.v2.service.SchoolService;
import com.fc.v2.service.StudentService;
import com.fc.v2.util.DateUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.*;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
/*
 * 学生和管理员的登陆首页，显示用户的基本信息，但是学生的有所限制
 * 添加学生后给予学生登陆、修改个人信息页权限
 * 添加管理员需要附加所管理学校Id   添加管理员后给予管理员登陆、学生管理、专业查询、班级管理、院系管理的权限
 * 
 * */
/**
 * Controller
 * @ClassName: StudentController
 * @author fuce
 * @date 2023-11-21 10:48:39
 */
@Api(value = "")
@Controller
@RequestMapping("/StudentController")
public class StudentController extends BaseController{


	private String prefix = "gen/student";
	
	private static final String NORMALPSW = "000000";
	@Autowired
	private ClassService classService;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private DepartService departService;
	
	@Autowired
	private MajorService majorService;
	
	@Autowired
	private StudentService studentService;
	
	/**
	 * 页面展示
	 * @param model
	 * @return String
	 * @author fuce
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:student:view")
    public String view(ModelMap model)
    {
		Student student = studentService.selectByPrimaryKey("aa");
		model.addAttribute("studentInfo", student);
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
	@RequiresPermissions("gen:student:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,Student student){
		PageInfo<Student> page=studentService.list(tablepar,student) ; 
		return pageTable(page.getList(),page.getTotal());
	}
	
	/**
     * 新增跳转
     */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
		List<Depart> de = departService.selectByExample(null);
		List<Major> ma = majorService.selectByExample(null);
		modelMap.put("departList", de);
		modelMap.put("majorList", ma);
		return prefix + "/add";
    }
	/**
     * 新增保存
     * 这里写的很乱要整理
     * @param 
     * @return
     */

	//@Log(title = "新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:student:add")
	@ResponseBody
	public AjaxResult add(studentBO sb){
		Subject currentUser = SecurityUtils.getSubject();
		TsysUser t = (TsysUser)currentUser.getPrincipal();
		
		Student student = sb.getStudent();
		com.fc.v2.model.auto.Class t_class = sb.getClas();
		t_class.setSchoolId(t.getSchoolId());
		
		Major major = majorService.selectByPrimaryKey(t_class.getMajorId());
	
		

		School school = schoolService.selectByPrimaryKey(t.getSchoolId());
		
		
		Depart depart = departService.selectByPrimaryKey(t_class.getDepartId());
		String yyyy = DateUtils.format(t_class.getAdmissionTime(), "yyyy");
		
		String className = new StringBuilder().append(school.getSchoolName()).append("学校")
				.append(yyyy).append("年级")
				.append(depart.getDepartName()).append("院系")
				.append(major.getMajorName()).append("专业")
				.append(t_class.getClassNum()).append("班").toString();
		t_class.setClassName(className);
		String cc = classService.insertSelectives(t_class);

		if(cc == null){
			return error("class添加失败");
		}
		student.setPassword(NORMALPSW);
		student.setClassCode(cc);
		int b=studentService.insertSelective(student);
		
		if(b>0){
			return success();
		}else{
			return error("class添加失败");
		}
		
	}
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:student:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=studentService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	
	/**
	 * 修改跳转
	 * @param id
	 * @param mmap
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        map.put("Student", studentService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	
	/**
     * 修改保存
     */
    //@Log(title = "修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:student:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Student student)
    {
        return toAjax(studentService.updateByPrimaryKeySelective(student));
    }
    
    
    /**
	 * 修改状态
	 * @param record
	 * @return
	 */
    @PutMapping("/updateVisible")
	@ResponseBody
    public AjaxResult updateVisible(@RequestBody Student student){
		int i=studentService.updateVisible(student);
		return toAjax(i);
	}

    
    

	
}
