package com.harish.dl.models;

public class AuthorEntityResponseModel {
	private int id;
	private String name;
	private String email;
	private int age;
	private String country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	@Override
	public String toString() {
		return "AuthorEntityResponseModel [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age
				+ ", country=" + country + "]";
	}
	public AuthorEntityResponseModel(int id, String name, String email, int age, String country) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.country = country;
	}
	public AuthorEntityResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
