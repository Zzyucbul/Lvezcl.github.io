package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.Major;
import com.fc.v2.model.auto.MajorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *  MajorMapper
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-11-08 18:02:57
 */
public interface MajorMapper {
      	   	     
	@Select("select MAX(major_id) from t_major")
	String selectMAX();
	
    long countByExample(MajorExample example);

    int deleteByExample(MajorExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(Major record);

    int insertSelective(Major record);

    List<Major> selectByExample(MajorExample example);
		
    Major selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") Major record, @Param("example") MajorExample example);

    int updateByExample(@Param("record") Major record, @Param("example") MajorExample example); 
		
    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
  	  	
}