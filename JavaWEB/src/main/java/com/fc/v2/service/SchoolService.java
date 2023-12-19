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
import com.fc.v2.mapper.auto.SchoolMapper;
import com.fc.v2.model.auto.School;
import com.fc.v2.model.auto.SchoolExample;
import com.fc.v2.model.auto.TSysDictData;
import com.fc.v2.model.auto.TSysDictDataExample;
import com.fc.v2.model.auto.TsysRole;
import com.fc.v2.model.auto.TsysRoleExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;

/**
 *  SchoolService
 * @Title: SchoolService.java 
 * @Package com.fc.v2.service 
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-11-08 22:20:36  
 **/
@Service
public class SchoolService implements BaseService<School, SchoolExample>{
	@Autowired
	private SchoolMapper schoolMapper;
	
      	   	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<School> list(Tablepar tablepar,School school){
	        SchoolExample testExample=new SchoolExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(school);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("school_id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<School> list= schoolMapper.selectByExample(testExample);
	        PageInfo<School> pageInfo = new PageInfo<School>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			SchoolExample example=new SchoolExample();
			example.createCriteria().andSchoolIdIn(lista);
			return schoolMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public School selectByPrimaryKey(String id) {
				
			return schoolMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(School record) {
		return schoolMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(School record) {
				
		//添加雪花主键id
		//record.setSchoolId(SnowflakeIdWorker.getUUID());
			String code=schoolMapper.selectMAX();
			if(code == null) {
				code = "0001";
			} else {
				Integer c=new Integer(code);
				c= c + 1;
				code=String.format("%04d", c);
			}
			record.setSchoolId(code);
		return schoolMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(School record, SchoolExample example) {
		
		return schoolMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(School record, SchoolExample example) {
		
		return schoolMapper.updateByExample(record, example);
	}

	@Override
	public List<School> selectByExample(SchoolExample example) {
		
		return schoolMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(SchoolExample example) {
		
		return schoolMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(SchoolExample example) {
		
		return schoolMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param school
	 * @return
	 */
	public int updateVisible(School school) {
		return schoolMapper.updateByPrimaryKeySelective(school);
	}
	
	

	/**
	 * 检查学校name
	 * @param schoolName
	 * @return
	 */
	public int checkNameUnique(School school){
		SchoolExample example=new SchoolExample();
		example.createCriteria().andSchoolNameEqualTo(school.getSchoolName());
		List<School> list=schoolMapper.selectByExample(example);
		return list.size();
	}
	


}
