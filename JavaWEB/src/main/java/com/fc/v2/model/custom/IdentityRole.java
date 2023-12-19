package com.fc.v2.model.custom;

import java.io.Serializable;

public class IdentityRole implements Serializable  {
	private String role;
	private Object overload;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Object getOverload() {
		return overload;
	}
	public void setOverload(Object overload) {
		this.overload = overload;
	}
	public IdentityRole(String role, Object overload) {
		super();
		this.role = role;
		this.overload = overload;
	}
	public IdentityRole() {
		
	}
	
}