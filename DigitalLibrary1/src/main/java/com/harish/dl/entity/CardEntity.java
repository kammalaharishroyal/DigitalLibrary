package com.harish.dl.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class CardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String status="valid";
	//@OneToMany(cascade = CascadeType.ALL,mappedBy = "card")
//	@JoinColumn(name="card_id",referencedColumnName = "id")
	//private List<TransactionEntity> cardtrans;
	private LocalDate validUpto=LocalDate.now().plusDays(365);
	private LocalDate UpdatedOn=LocalDate.now();
	
	
	public LocalDate getValidUpto() {
		return validUpto;
	}
	public void setValidUpto(LocalDate validUpto) {
		this.validUpto = validUpto;
	}
	public LocalDate getUpdatedOn() {
		return UpdatedOn;
	}
	public void setUpdatedOn(LocalDate updatedOn) {
		UpdatedOn = updatedOn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public List<TransactionEntity> getCardtrans() {
//		return cardtrans;
//	}
//	public void setCardtrans(List<TransactionEntity> cardtrans) {
//		this.cardtrans = cardtrans;
//	}
	@Override
	public String toString() {
		return "CardEntity [id=" + id + ", status=" + status +  "]";
	}
	public CardEntity(int id, String status, List<TransactionEntity> cardtrans) {
		super();
		this.id = id;
		this.status = status;
	//	this.cardtrans = cardtrans;
	}
	public CardEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	 

}
