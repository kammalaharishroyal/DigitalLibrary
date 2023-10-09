package com.harish.dl.models;

public class AuthorEntityRequestModel {

	
	private String name;
	private String email;
	private int age;
	private String country;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public AuthorEntityRequestModel(String name, String email, int age, String country) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.country = country;
	}
	public AuthorEntityRequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AuthorEntityRequestModel [name=" + name + ", email=" + email + ", age=" + age + ", country=" + country
				+ "]";
	}
	
	
}
