package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.Student;

import com.fc.v2.model.auto.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  StudentMapper
 * @author fuce_自动生成
 * @email ${email}
 * @date 2023-11-21 10:48:39
 */
public interface StudentMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);
		
    Student selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example); 
		
    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
  	  	
}