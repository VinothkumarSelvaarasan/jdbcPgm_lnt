package com.ltnecc.com;

public class Registeration {

	private int Id;
	private String name;
	private String dept;
	private String gender;
	
	public Registeration() {
		super();
	}

	public Registeration(int id, String name, String dept, String gender) {
		super();
		Id = id;
		this.name = name;
		this.dept = dept;
		this.gender = gender;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
}
