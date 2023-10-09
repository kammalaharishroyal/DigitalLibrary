package com.harish.dl.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "enter valid name")
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	private AuthorEntity aid;
	private int noPages;
	@NotNull (message = "language shouldn't be null")
	private String language;
	@NotNull (message = "status shouldn't be null")
	private boolean status;
	@NotNull (message = "genre shouldn't be null")
	private String genre;
	@NotNull (message = "genre shouldn't be null")
	private int isbn;
	
	private LocalDate publishedDate=LocalDate.now();
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
//	//@JoinColumn(name = "bkid_fk",referencedColumnName = "id")
//	private List<TransactionEntity> trans;
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getNoPages() {
		return noPages;
	}
	public void setNoPages(int noPages) {
		this.noPages = noPages;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public LocalDate getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
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
	public AuthorEntity getAid() {
		return aid;
	}
	public void setAid(AuthorEntity aid) {
		this.aid = aid;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean getStatus( ) {
		return status;
	}
//	public List<TransactionEntity> getTrans() {
//		return trans;
//	}
//	public void setTrans(List<TransactionEntity> trans) {
//		this.trans = trans;
//	}
	public BookEntity(int id, String name, AuthorEntity aid, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.aid = aid;
		this.status = status;
//		this.trans = trans;
	}
	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", name=" + name + ", aid=" + aid + ", status=" + status  + "]";
	}
	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
