
package com.fc.v2.model.auto;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class studentBO{

	public static HashSet ethnic = new HashSet<String>();


	private Student student;
	private com.fc.v2.model.auto.Class t_class;
	public studentBO(String studentId,String studentName,String studentIdcard,Byte sex,String ethnic,String origin,String address,String graduateName,String political,String phoneNumber,String password,String classCode
			,String className,String schoolId,String departId,String majorId,@DateTimeFormat(pattern="yyyy-MM-dd ")Date admissionTime,String classNum)
	{
		student = new Student(studentId,studentName,studentIdcard,sex,ethnic,origin,address,graduateName,political,phoneNumber,password,classCode);
		t_class = new Class(classCode,className,schoolId,departId,majorId,admissionTime,classNum);
	}
	public com.fc.v2.model.auto.Class getClas() {
		return t_class;
	}
	public Student getStudent() {
		return student;
	}
	
	
}
