package com.fc.v2.service;

import java.util.List;
import java.util.Arrays;

import com.fc.v2.mapper.auto.SchoolMapper;
import com.fc.v2.model.auto.SchoolExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.DepartMapper;
import com.fc.v2.model.auto.Depart;
import com.fc.v2.model.auto.DepartExample;
import com.fc.v2.model.auto.School;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;

/**
 *  DepartService
 * @Title: DepartService.java 
 * @Package com.fc.v2.service 
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-11-15 08:36:15  
 **/
@Service
public class DepartService implements BaseService<Depart, DepartExample>{
	@Autowired
	private DepartMapper departMapper;
	@Autowired
	private SchoolMapper schoolMapper;
      	   	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Depart> list(Tablepar tablepar,Depart depart){
	        DepartExample testExample=new DepartExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(depart);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("depart_id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<Depart> list= departMapper.selectByExample(testExample);
	        PageInfo<Depart> pageInfo = new PageInfo<Depart>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			DepartExample example=new DepartExample();
			example.createCriteria().andDepartIdIn(lista);
			return departMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public Depart selectByPrimaryKey(String id) {
				
			return departMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(Depart record) {
		return departMapper.updateByPrimaryKeySelective(record);
	}
	
	
	public List<School> getDataFromDataBase(SchoolExample s){
		List<School> schools=schoolMapper.selectByExample(s);
		
		return schools;
		
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Depart record) {
				
		//添加雪花主键id
//		record.setDepartId(SnowflakeIdWorker.getUUID());
		String code = departMapper.selectMax();
		if(code == null) {
			code = "0001";
		}else {
			Integer c=new Integer(code);
			c = c+1;
			code = String.format("%04d", c);
		}
		record.setDepartId(code);
			
	return departMapper.insertSelective(record);
			
	}
	
	
	@Override
	public int updateByExampleSelective(Depart record, DepartExample example) {
		
		return departMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Depart record, DepartExample example) {
		
		return departMapper.updateByExample(record, example);
	}

	@Override
	public List<Depart> selectByExample(DepartExample example) {
		
		return departMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(DepartExample example) {
		
		return departMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(DepartExample example) {
		
		return departMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param depart
	 * @return
	 */
	public int updateVisible(Depart depart) {
		return departMapper.updateByPrimaryKeySelective(depart);
	}


}
