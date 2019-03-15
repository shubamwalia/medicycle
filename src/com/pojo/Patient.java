package com.pojo;

public class Patient {
	private String name;
	private String disease;
	public Patient() {}
	
	public Patient(String name, String disease) {
		super();
		this.name = name;
		this.disease = disease;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", city=" + disease + "]";
	}
	
	
}
