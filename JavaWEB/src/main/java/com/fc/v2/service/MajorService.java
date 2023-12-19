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
import com.fc.v2.mapper.auto.MajorMapper;
import com.fc.v2.model.auto.Major;
import com.fc.v2.model.auto.MajorExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.fc.v2.util.StringUtils;

/**
 *  MajorService
 * @Title: MajorService.java 
 * @Package com.fc.v2.service 
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-11-08 18:02:57  
 **/
@Service
public class MajorService implements BaseService<Major, MajorExample>{
	@Autowired
	private MajorMapper majorMapper;
	
      	   	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Major> list(Tablepar tablepar,Major major){
	        MajorExample testExample=new MajorExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(major);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("major_id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<Major> list= majorMapper.selectByExample(testExample);
	        PageInfo<Major> pageInfo = new PageInfo<Major>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			MajorExample example=new MajorExample();
			example.createCriteria().andMajorIdIn(lista);
			return majorMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public Major selectByPrimaryKey(String id) {
				
			return majorMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(Major record) {
		return majorMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Major record) {
				
		//添加雪花主键id
//		record.setMajorId(SnowflakeIdWorker.getUUID());
			String code=majorMapper.selectMAX();
			if(code == null) {
				code = "0001";
			} else {
				Integer c=new Integer(code);
				c=c+1;
				code=String.format("%04d", c);	
			}
			record.setMajorId(code);
				
		return majorMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(Major record, MajorExample example) {
		
		return majorMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Major record, MajorExample example) {
		
		return majorMapper.updateByExample(record, example);
	}

	@Override
	public List<Major> selectByExample(MajorExample example) {
		
		return majorMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(MajorExample example) {
		
		return majorMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(MajorExample example) {
		
		return majorMapper.deleteByExample(example);
	}
	
	/**
	 * 修改权限状态展示或者不展示
	 * @param major
	 * @return
	 */
	public int updateVisible(Major major) {
		return majorMapper.updateByPrimaryKeySelective(major);
	}


}
