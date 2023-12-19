package com.fc.v2.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "")
	private String studentId;
	
	@ApiModelProperty(value = "")
	private String studentName;
	
	@ApiModelProperty(value = "")
	private String studentIdcard;
	
	@ApiModelProperty(value = "")
	private Byte sex;
	
	@ApiModelProperty(value = "")
	private String ethnic;
	
	@ApiModelProperty(value = "")
	private String origin;
	
	@ApiModelProperty(value = "")
	private String address;
	
	@ApiModelProperty(value = "")
	private String graduateName;
	
	@ApiModelProperty(value = "")
	private String political;
	
	@ApiModelProperty(value = "")
	private String phoneNumber;
	
	@ApiModelProperty(value = "")
	private String password;
	
	@ApiModelProperty(value = "")
	private String classCode;
	
	@JsonProperty("studentId")
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId =  studentId;
	}
	@JsonProperty("studentName")
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName =  studentName;
	}
	@JsonProperty("studentIdcard")
	public String getStudentIdcard() {
		return studentIdcard;
	}

	public void setStudentIdcard(String studentIdcard) {
		this.studentIdcard =  studentIdcard;
	}
	@JsonProperty("sex")
	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex =  sex;
	}
	@JsonProperty("ethnic")
	public String getEthnic() {
		return ethnic;
	}

	public void setEthnic(String ethnic) {
		this.ethnic =  ethnic;
	}
	@JsonProperty("origin")
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin =  origin;
	}
	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address =  address;
	}
	@JsonProperty("graduateName")
	public String getGraduateName() {
		return graduateName;
	}

	public void setGraduateName(String graduateName) {
		this.graduateName =  graduateName;
	}
	@JsonProperty("political")
	public String getPolitical() {
		return political;
	}

	public void setPolitical(String political) {
		this.political =  political;
	}
	@JsonProperty("phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber =  phoneNumber;
	}
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password =  password;
	}
	@JsonProperty("classCode")
	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode =  classCode;
	}

																								
	public Student(String studentId,String studentName,String studentIdcard,Byte sex,String ethnic,String origin,String address,String graduateName,String political,String phoneNumber,String password,String classCode) {
				
		this.studentId = studentId;
				
		this.studentName = studentName;
				
		this.studentIdcard = studentIdcard;
				
		this.sex = sex;
				
		this.ethnic = ethnic;
				
		this.origin = origin;
				
		this.address = address;
				
		this.graduateName = graduateName;
				
		this.political = political;
				
		this.phoneNumber = phoneNumber;
				
		this.password = password;
				
		this.classCode = classCode;
				
	}

	public Student() {
	    super();
	}

	

}