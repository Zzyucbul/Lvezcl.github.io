package com.fc.v2.model.auto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class Major implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "")
	private String majorId;
	
	@ApiModelProperty(value = "")
	private String majorName;
	
	@JsonProperty("majorId")
	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId =  majorId;
	}
	@JsonProperty("majorName")
	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName =  majorName;
	}

				
	public Major(String majorId,String majorName) {
				
		this.majorId = majorId;
				
		this.majorName = majorName;
				
	}

	public Major() {
	    super();
	}

	

}