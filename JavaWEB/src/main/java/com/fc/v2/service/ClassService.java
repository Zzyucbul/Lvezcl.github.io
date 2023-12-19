package com.fc.v2.service;

import java.util.List;
import java.util.Arrays;

import com.fc.v2.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.ClassMapper;
import com.fc.v2.model.auto.Class;
import com.fc.v2.model.auto.ClassExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;
import org.springframework.util.unit.DataUnit;

/**
 *  ClassService
 * @Title: ClassService.java 
 * @Package com.fc.v2.service 
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-11-21 10:23:24  
 **/
@Service
public class ClassService implements BaseService<Class, ClassExample>{
	@Autowired
	private ClassMapper classMapper;

      	   	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Class> list(Tablepar tablepar,Class t_class){
	        ClassExample testExample=new ClassExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(t_class);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("class_code ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<Class> list= classMapper.selectByExample(testExample);
	        PageInfo<Class> pageInfo = new PageInfo<Class>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			ClassExample example=new ClassExample();
			example.createCriteria().andClassCodeIn(lista);
			return classMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public Class selectByPrimaryKey(String id) {
				
			return classMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(Class record) {
		return classMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 * @return
	 */
	@Override
	public int insertSelective(Class record) {
		StringBuilder b = new StringBuilder();
		String yyyy = DateUtils.format(record.getAdmissionTime(), "yyyy");
		String cc = b.append(record.getSchoolId())
				.append(yyyy)
				.append(record.getDepartId())
				.append(record.getMajorId())
				.append(record.getClassNum()).toString();
		record.setClassCode(cc);
		int i = classMapper.insertSelective(record);
		return Integer.parseInt(cc);
	}

	public String insertSelectives(Class record) {
		StringBuilder b = new StringBuilder();

		
		String yyyy = DateUtils.format(record.getAdmissionTime(), "yyyy");
		String cc = b.append(record.getSchoolId())
				.append(yyyy)
				.append(record.getDepartId())
				.append(record.getMajorId())
				.append(record.getClassNum()).toString();
		record.setClassCode(cc);
		
		
		
		try {
			classMapper.insertSelective(record);
		}finally {
			return cc;
		}


	}

	
	
	@Override
	public int updateByExampleSelective(Class record, ClassExample example) {
		
		return classMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Class record, ClassExample example) {
		
		return classMapper.updateByExample(record, example);
	}

	@Override
	public List<Class> selectByExample(ClassExample example) {
		
		return classMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ClassExample example) {
		
		return classMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ClassExample example) {
		
		return classMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param class
	 * @return
	 */
	public int updateVisible(Class t_class) {
		return classMapper.updateByPrimaryKeySelective(t_class);
	}


}
