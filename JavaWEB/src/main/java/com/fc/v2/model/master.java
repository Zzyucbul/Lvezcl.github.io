package com.fc.v2.model;



public class master {
	private String name;
	private String color;
	private String skill;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public master(String name, String color, String skill) {
		super();
		this.name = name;
		this.color = color;
		this.skill = skill;
	}
	public master() {
		super();
	}
	@Override
	public String toString() {
		return "master [name=" + name + ", color=" + color + ", skill=" + skill + "]";
	}
	
	
}
