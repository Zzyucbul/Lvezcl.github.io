package com.fc.v2.controller.admin;

import com.aizuda.monitor.OshiMonitor;
import com.fc.v2.common.base.BaseController;
import com.fc.v2.model.auto.Student;
import com.fc.v2.model.auto.SysNotice;
import com.fc.v2.model.auto.TsysOperLog;
import com.fc.v2.model.auto.TsysUser;
import com.fc.v2.service.ClassService;
import com.fc.v2.service.DepartService;
import com.fc.v2.service.MajorService;
import com.fc.v2.service.SchoolService;
import com.fc.v2.service.StudentService;
import com.fc.v2.shiro.util.ShiroUtils;
import com.fc.v2.model.auto.Class;
import com.fc.v2.model.auto.Depart;
import com.fc.v2.model.auto.Major;
import com.fc.v2.model.auto.School;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 服务器信息Controller
 * 
 * @ClassName: ServiceController
 * @author fuce
 * @date 2019-06-23 00:55
 * @version V1.0
 */
@Api(value = "服务器信息")
@Controller
@RequestMapping("/ServiceController")
public class ServiceController extends BaseController {

	// 跳转页面参数
	private final String prefix = "admin/service";
	@Autowired
	private StudentService studentService;
	@Resource
	private OshiMonitor oshiMonitor;
	@Autowired
	private ClassService classService;
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private DepartService departService;
	
	@Autowired
	private MajorService majorService;
	/**
	 * 展示页面
	 * 
	 * @param model
	 * @return
	 * @author fuce
	 * @throws IOException 
	 * @throws ServletException 
	 * @Date 2019年11月11日 下午4:04:03
	 */
	@ApiOperation(value = "展示页面", notes = "展示页面")
	@GetMapping("/view")
	@RequiresPermissions("student:view")
	public void view(ModelMap model, HttpServletRequest hrq,HttpServletResponse hrp) throws IOException, ServletException {
		Subject currentUser = SecurityUtils.getSubject();
		TsysUser cur = (TsysUser) currentUser.getPrincipal();
		String role = cur.getRole();
		
	
		//forward to  particular controller
		if (role.equals("student")) {
			hrq.getRequestDispatcher("student/index").forward(hrq, hrp);
		}else if( role.equals("manager") ) {
			hrq.getRequestDispatcher("manager/index").forward(hrq, hrp);
		}else {
			hrq.getRequestDispatcher("manager/index").forward(hrq, hrp);
		}	
	}
	
	//返回学生用户首页
		@GetMapping("/student/index")
		@RequiresPermissions("student:view")
	    public String stuIndex(ModelMap model)
	    {
			Subject currentUser = SecurityUtils.getSubject();
			TsysUser cur = (TsysUser) currentUser.getPrincipal();
			String id = cur.getId();
			Student st = studentService.selectByPrimaryKey(id);
			Class cl = classService.selectByPrimaryKey(st.getClassCode());
			Depart  dp= departService.selectByPrimaryKey(cl.getDepartId());
			Major mj = majorService.selectByPrimaryKey(cl.getMajorId());
			School sc = schoolService.selectByPrimaryKey(cl.getSchoolId());
			String ey = st.getClassCode().subSequence(4, 8).toString();
			String gd = st.getSex() == 1 ? "男" : "女";
			
			model.addAttribute("studentInfo", st);
			model.addAttribute("classInfo", cl);
			model.addAttribute("departInfo", dp);
			model.addAttribute("majorInfo", mj);
			model.addAttribute("schoolInfo", sc);
			model.addAttribute("gender", gd);
			model.addAttribute("ey", ey);
			
	        return "gen/student/index";
	    }
		
		
		//返回学生用户首页
		@GetMapping("/manager/index")
		@RequiresPermissions("system:service:view")
		public String manIndex(ModelMap model,HttpServletRequest request)
		{
					
			List<SysNotice> sysNotices = sysNoticeService.getNEW();
			List<TsysOperLog> sysOperLog = sysOperLogService.getNEW();
			if (sysNotices == null || sysNotices.size() <= 0) {
				SysNotice sysNotice = new SysNotice();
				sysNotice.setId("0");
				sysNotice.setTitle("暂无公告");
				sysNotice.setCreateTime(new Date());
				sysNotices.add(sysNotice);
			}

			long nd = 1000 * 24 * 60 * 60;
			long nh = 1000 * 60 * 60;
			long nm = 1000 * 60;
			long ns = 1000;
			// 获得两个时间的毫秒时间差异
			long diff = oshiMonitor.getJvmInfo().getUptime();
			// 计算差多少天
			long day = diff / nd;
			// 计算差多少小时
			long hour = diff % nd / nh;
			// 计算差多少分钟
			long min = diff % nd % nh / nm;
			// 计算差多少秒//输出结果
			//long sec = diff % nd % nh % nm / ns;

			model.addAttribute("runtime", day + "天" + hour + "小时" + min + "分钟");
			model.addAttribute("service", oshiMonitor);
			model.addAttribute("sysNotices", sysNotices);
			model.addAttribute("sysOperLog", sysOperLog);
			return  prefix+"/list";
			}
		
}

