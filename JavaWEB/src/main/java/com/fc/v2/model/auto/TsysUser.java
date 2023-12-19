package com.fc.v2.model.auto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class TsysUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "角色")
	private String role;
	
	/** 主键 **/
	@ApiModelProperty(value = "主键")
	private String id;
		
	/** 用户账号 **/
	@ApiModelProperty(value = "用户账号")
	private String username;
		
	/** 用户密码 **/
	@ApiModelProperty(value = "用户密码")
	private String password;
		
	@ApiModelProperty(value = "管理学校ID")
	private String schoolId;
	

    public TsysUser(String id, String username, String password, String schoolId,String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.schoolId = schoolId;
		this.role = role;
	}
    public TsysUser(String id, String username, String password, String schoolId) {
    	this(id, username, password, schoolId,"0000");
		
	}
	
	public TsysUser() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

   
    
    
}