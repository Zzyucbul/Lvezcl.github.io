package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.School;
import com.fc.v2.model.auto.SchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *  SchoolMapper
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-11-08 22:20:36
 */
public interface SchoolMapper {
      	   	      	      
	@Select ("select MAX(school_id) from t_school")
	String selectMAX();


    long countByExample(SchoolExample example);

    int deleteByExample(SchoolExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(School record);

    int insertSelective(School record);

    //....
    List<School> selectByExample(SchoolExample example);
		
    School selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") School record, @Param("example") SchoolExample example);

    int updateByExample(@Param("record") School record, @Param("example") SchoolExample example); 
		
    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);
  	  	
}