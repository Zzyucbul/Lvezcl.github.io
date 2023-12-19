package com.fc.v2.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class Depart implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "")
	private String departId;
	
	@ApiModelProperty(value = "")
	private String departName;
	
	@ApiModelProperty(value = "")
	private String schoolId;
	
	@JsonProperty("departId")
	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId =  departId;
	}
	@JsonProperty("departName")
	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName =  departName;
	}
	@JsonProperty("schoolId")
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId =  schoolId;
	}

						
	public Depart(String departId,String departName,String schoolId) {
				
		this.departId = departId;
				
		this.departName = departName;
				
		this.schoolId = schoolId;
				
	}

	public Depart() {
	    super();
	}

	

}