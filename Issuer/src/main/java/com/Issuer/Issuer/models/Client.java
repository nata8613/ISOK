package com.Issuer.Issuer.models;

import static javax.persistence.CascadeType.ALL;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(nullable = true)
	private double reserved;
	
	@Column(nullable = false)
	private Date validTo;
	
	@OneToMany(cascade={ALL}, fetch=FetchType.LAZY, mappedBy="client")
	@JsonIgnore
	private Set<Transaction> transactions = new HashSet<Transaction>();

	public Client() {
		
	}
	

	public Client(String cardHolderName, long accountNumber, int securityCode, double balance, double reserved,
			Date validTo) {
		super();
		this.cardHolderName = cardHolderName;
		this.accountNumber = accountNumber;
		this.securityCode = securityCode;
		this.balance = balance;
		this.reserved = reserved;
		this.validTo = validTo;
	}


	public int getSecurityCode() {
		return securityCode;
	}


	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}


	public double getReserved() {
		return reserved;
	}


	public void setReserved(double reserved) {
		this.reserved = reserved;
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

