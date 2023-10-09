package com.harish.dl.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class TransactionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Override
	public String toString() {
		return "TransactionEntity [id=" + id + ", isIssued=" + isIssued + ", isReturned=" + isReturned + ", fineAmount="
				+ fineAmount + ", createdOn=" + createdOn + ", bookDueDate=" + bookDueDate + ", returnedOn="
				+ returnedOn + ", card=" + card + ", book=" + book + "]";
	}
	//	private long cardId;
//	@OneToOne(cascade = CascadeType.ALL)
//	private BookEntity bookid; 
//	private LocalDate transactionDate=LocalDate.now();
	@NotNull(message = "issued status should be boolean--true or false")
	private boolean isIssued;
	@NotNull(message = "issued status should be boolean--true or false")
	private boolean isReturned;
	private int fineAmount=10;
//	private boolean status;
	
	private LocalDate createdOn=LocalDate.now();
	private LocalDate bookDueDate=createdOn.plusDays(5);
	private LocalDate returnedOn;//=LocalDate.now();
//	private LocalDate updatedOn;//=LocalDate.now();
	
	@ManyToOne
	private CardEntity card;
	@ManyToOne
	private BookEntity book;

	public CardEntity getCard() {
		return card;
	}
	public void setCard(CardEntity card) {
		this.card = card;
	}
	public BookEntity getBook() {
		return book;
	}
	public void setBook(BookEntity book) {
		this.book = book;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
//	public BookEntity getBookid() {
//		return bookid;
//	}
//	public void setBookid(BookEntity bookid) {
//		this.bookid = bookid;
//	}
	
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	public int getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}
//	public boolean isStatus() {
//		return status;
//	}
//	public void setStatus(boolean status) {
//		this.status = status;
//	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDate getBookDueDate() {
		return bookDueDate;
	}
	public void setBookDueDate(LocalDate bookDueDate) {
		this.bookDueDate = bookDueDate;
	}
	public LocalDate getReturnedOn() {
		return returnedOn;
	}
	public void setReturnedOn(LocalDate returnedOn) {
		this.returnedOn = returnedOn;
	}
	
	public TransactionEntity(int id, long cardId, boolean isIssued,
			boolean isReturned, int fineAmount, LocalDate createdOn, LocalDate bookDueDate,
			LocalDate returnedOn, LocalDate updatedOn) {
		super();
		this.id = id;
		//this.cardId = cardId;
		//this.bookid = bookid;
		//this.transactionDate = transactionDate;
		this.isIssued = isIssued;
		this.isReturned = isReturned;
		this.fineAmount = fineAmount;
	//	this.status = status;
		this.createdOn = createdOn;
		this.bookDueDate = bookDueDate;
		this.returnedOn = returnedOn;
	//	this.updatedOn = updatedOn;
	}
	public TransactionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
