package com.harish.dl.models;

import com.harish.dl.entity.AuthorEntity;


public class BookEntityRequestModel {
	
	private String name;
	
	private AuthorEntity aid;
	private int noPages;
	private String language;
	private boolean status=true;
	private int isbn;
	private String genre;
	
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
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
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
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
	public boolean getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "BookEntityRequestModel [name=" + name + ", aid=" + aid + ", status=" + status + "]";
	}
	public BookEntityRequestModel(String name, AuthorEntity aid) {
		super();
		this.name = name;
		this.aid = aid;
	}
	
	
	
}
