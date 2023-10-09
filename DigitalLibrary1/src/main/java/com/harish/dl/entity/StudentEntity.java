package com.harish.dl.entity;

import org.hibernate.annotations.Parent;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class StudentEntity {
	
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone
				+ ", country=" + country + ", cardId=" + cardId + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "name should not be null")
	private String name;
	@Min(18)
	@Max(30)
	private int age;
	@Email
	private String email;
	@NotNull
	//@Pattern(regexp = "^\\d{10}$")
	private long phone;
	@NotBlank
	private String country;
	@OneToOne(cascade = CascadeType.ALL)
	private CardEntity cardId;
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
	public CardEntity getCardId() {
		return cardId;
	}
	public void setCardId(CardEntity cardId) {
		this.cardId = cardId;
	}
	public StudentEntity(int id, String name, CardEntity cardId) {
		super();
		this.id = id;
		this.name = name;
		this.cardId = cardId;
	}
	public StudentEntity() {
		// TODO Auto-generated constructor stub
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	


}
