package com.fc.v2.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class School implements Serializable {
    private static final long serialVersionUID = 1L;

	

	private String schoolId;
	

	private String schoolName;
	
	@JsonProperty("schoolId")
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId =  schoolId;
	}
	@JsonProperty("schoolName")
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName =  schoolName;
	}

				
	public School(String schoolId,String schoolName) {
				
		this.schoolId = schoolId;
				
		this.schoolName = schoolName;
				
	}

	public School() {
	    super();
	}

	

}