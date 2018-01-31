package com.Acquirer.Acquirer.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String cardHolderName;
	
	@Column(nullable = false)
	private long accountNumber;
	
	@Column(nullable = false)
	private int securityCode;
	
	@Column(nullable = false)
	private double balance;
	
	@Column(nullable = false)
	private Date validTo;

	public Client() {
		
	}

	public Client(String cardHolderName, long accountNumber, double balance, Date validTo) {
		super();
		this.cardHolderName = cardHolderName;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.validTo = validTo;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public long getId() {
		return id;
	}
	
	
}
