package com.fc.v2.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class Class implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "")
	private String classCode;
	
	@ApiModelProperty(value = "")
	private String className;
	
	@ApiModelProperty(value = "")
	private String schoolId;
	
	@ApiModelProperty(value = "")
	private String departId;
	
	@ApiModelProperty(value = "")
	private String majorId;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	@ApiModelProperty(value = "")
	private Date admissionTime;
	
	@ApiModelProperty(value = "")
	private String classNum;
	
	@JsonProperty("classCode")
	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode =  classCode;
	}
	@JsonProperty("className")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className =  className;
	}
	@JsonProperty("schoolId")
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId =  schoolId;
	}
	@JsonProperty("departId")
	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId =  departId;
	}
	@JsonProperty("majorId")
	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId =  majorId;
	}
	@JsonProperty("admissionTime")
	public Date getAdmissionTime() {
		return admissionTime;
	}

	public void setAdmissionTime(Date admissionTime) {
		this.admissionTime =  admissionTime;
	}
	@JsonProperty("classNum")
	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum =  classNum;
	}

														
	public Class(String classCode,String className,String schoolId,String departId,String majorId,Date admissionTime,String classNum) {
				
		this.classCode = classCode;
				
		this.className = className;
				
		this.schoolId = schoolId;
				
		this.departId = departId;
				
		this.majorId = majorId;
			
		this.admissionTime = admissionTime;
				
		this.classNum = classNum;
				
	}

	public Class() {
	    super();
	}

	public String dateToStringConvert(Date date) {
		if(date!=null) {
			return DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	

}