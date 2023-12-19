package com.fc.v2.service;

import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.StudentMapper;
import com.fc.v2.mapper.auto.TSysRoleUserMapper;
import com.fc.v2.model.auto.Student;
import com.fc.v2.model.auto.StudentExample;
import com.fc.v2.model.auto.TSysRoleUser;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.MD5Util;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;

/**
 *  StudentService
 * @Title: StudentService.java 
 * @Package com.fc.v2.service 
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-11-21 10:48:39  
 **/
@Service
public class StudentService implements BaseService<Student, StudentExample>{
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private TSysRoleUserMapper tSysRoleUserMapper;
      	   	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Student> list(Tablepar tablepar,Student student){
	        StudentExample testExample=new StudentExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(student);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("student_id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<Student> list= studentMapper.selectByExample(testExample);
	        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			StudentExample example=new StudentExample();
			example.createCriteria().andStudentIdIn(lista);
			return studentMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public Student selectByPrimaryKey(String id) {
				
			return studentMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(Student record) {
		return studentMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Student record) {
				
		//添加雪花主键id

		StringBuilder stringBuilder = new StringBuilder();
		String sc = stringBuilder.append('X')
				.append(record.getStudentIdcard()).toString();
		record.setStudentId(sc);
		record.setPassword(MD5Util.encode(record.getPassword()));
		
		int r = studentMapper.insertSelective(record);
		
			 TSysRoleUser roleUser=new TSysRoleUser(SnowflakeIdWorker.getUUID(), sc,"889159217641033728");
			 tSysRoleUserMapper.insertSelective(roleUser);
		
		return r;
	}
	
	
	@Override
	public int updateByExampleSelective(Student record, StudentExample example) {
		
		return studentMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Student record, StudentExample example) {
		
		return studentMapper.updateByExample(record, example);
	}

	@Override
	public List<Student> selectByExample(StudentExample example) {
		
		return studentMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(StudentExample example) {
		
		return studentMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(StudentExample example) {
		
		return studentMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param student
	 * @return
	 */
	public int updateVisible(Student student) {
		return studentMapper.updateByPrimaryKeySelective(student);
	}


}
