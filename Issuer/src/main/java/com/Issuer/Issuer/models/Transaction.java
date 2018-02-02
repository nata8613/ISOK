package com.Issuer.Issuer.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = true)
	private long issuerId;
	
	@Column(nullable = true)
	private Date issuerTimestamp;

	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private double amount;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name="client")
	private Client client;

	public Transaction() {
		
	}

	public Transaction(long issuerId, Date issuerTimestamp, String status, double amount, Client client) {
		super();
		this.issuerId = issuerId;
		this.issuerTimestamp = issuerTimestamp;
		this.status = status;
		this.amount = amount;
		this.client = client;
	}

	public long getIssuerId() {
		return issuerId;
	}

	public void setIssuerId(long issuerId) {
		this.issuerId = issuerId;
	}

	public Date getIssuerTimestamp() {
		return issuerTimestamp;
	}

	public void setIssuerTimestamp(Date issuerTimestamp) {
		this.issuerTimestamp = issuerTimestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public long getId() {
		return id;
	}


	
	
}
