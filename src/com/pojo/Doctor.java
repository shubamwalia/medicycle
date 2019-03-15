package com.pojo;

public class Doctor {
	private String name;
	private String designation;
	public Doctor() {
		
	}
	
	public Doctor(String name, String designation) {
		super();
		this.name = name;
		this.designation = designation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", designation=" + designation + "]";
	}
	
}
