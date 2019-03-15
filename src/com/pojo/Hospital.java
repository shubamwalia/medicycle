package com.pojo;

public class Hospital {
	private String name;
	private String city;

	public Hospital() {

	}

	public Hospital(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Hospital [name=" + name + ", city=" + city + "]";
	}
	
}
