package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.Depart;
import com.fc.v2.model.auto.DepartExample;
import com.fc.v2.model.auto.School;

import java.util.List;

import com.fc.v2.model.auto.SchoolExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *  DepartMapper
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-11-15 08:36:15
 */
public interface DepartMapper {
	
	@Select ("select MAX(depart_id) from t_depart")
	String selectMax();
	


	
    long countByExample(DepartExample example);

    int deleteByExample(DepartExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(Depart record);

    int insertSelective(Depart record);

    List<Depart> selectByExample(DepartExample example);
		
    Depart selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") Depart record, @Param("example") DepartExample example);

    int updateByExample(@Param("record") Depart record, @Param("example") DepartExample example); 
		
    int updateByPrimaryKeySelective(Depart record);

    int updateByPrimaryKey(Depart record);
  	  	
}