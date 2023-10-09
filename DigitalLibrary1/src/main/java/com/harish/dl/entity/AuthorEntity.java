package com.harish.dl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class AuthorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="author name should not be null")
	private String name;
	@Email(message = "invalid email adress")
	private String email;
	@Min(18)
	@Max(70)
	private int age;
	@NotBlank(message = "not valid")
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
		return "AuthorEntity [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", country="
				+ country + "]";
	}
	public AuthorEntity(int id, String name, String email, int age, String country) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.country = country;
	}
	public AuthorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
