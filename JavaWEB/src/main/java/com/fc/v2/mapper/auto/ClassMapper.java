package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.Class;
import com.fc.v2.model.auto.ClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *  ClassMapper
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-11-21 10:23:24
 */
public interface ClassMapper {
    
	@Select ("select MAX(class_code) from t_class")
	String selectMax();
	
    long countByExample(ClassExample example);

    int deleteByExample(ClassExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(Class record);

    int insertSelective(Class record);

    List<Class> selectByExample(ClassExample example);
		
    Class selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example); 
		
    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
    
    
  	  	
}