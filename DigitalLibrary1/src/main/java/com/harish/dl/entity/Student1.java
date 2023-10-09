package com.harish.dl.entity;

public class Student1 {
	@Override
	public String toString() {
		return "Student1 [name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password + "]";
	}
	private String name;
	private String email;
	private String phone;
	private String password;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Student1(String name, String email, String phone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public Student1() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
