package com.Acquirer.Acquirer.models;

import static javax.persistence.CascadeType.ALL;

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
@Table(name = "merchant")
public class Merchant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String merchantId;
	
	@Column(nullable = false)
	private String merchantPassword;
	
	@Column(nullable = false)
	private long accountNumber;
	
	@Column(nullable = false)
	private double balance;
	
	@OneToMany(cascade={ALL}, fetch=FetchType.LAZY, mappedBy="merchant")
	@JsonIgnore
	private Set<Transaction> transactions = new HashSet<Transaction>();

	public Merchant() {
	
	}

	public Merchant(String merchantId, String merchantPassword, long accountNumber, double balance,
			Set<Transaction> transactions) {
		super();
		this.merchantId = merchantId;
		this.merchantPassword = merchantPassword;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.transactions = transactions;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantPassword() {
		return merchantPassword;
	}

	public void setMerchantPassword(String merchantPassword) {
		this.merchantPassword = merchantPassword;
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

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public long getId() {
		return id;
	}
	
	
	
}
