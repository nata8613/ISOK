package com.Acquirer.Acquirer.models;

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
	private String acquirerId;
	
	@Column(nullable = true)
	private Date acquirerTimestamp;
	
	@Column(nullable = false)
	private long paymentID;
	
	@Column(nullable = false)
	private long merchantOrderId;
	
	@Column(nullable = false)
	private double amount;
	
	@Column(nullable = false)
	private String status;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name="merchant")
	private Merchant merchant;

	public Transaction() {
		
	}

	

	public Transaction(String acquirerId, Date acquirerTimestamp, long paymentID, long merchantOrderId, double amount,
			String status, Merchant merchant) {
		super();
		this.acquirerId = acquirerId;
		this.acquirerTimestamp = acquirerTimestamp;
		this.paymentID = paymentID;
		this.merchantOrderId = merchantOrderId;
		this.amount = amount;
		this.status = status;
		this.merchant = merchant;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getAcquirerId() {
		return acquirerId;
	}

	public void setAcquirerId(String acquirerId) {
		this.acquirerId = acquirerId;
	}

	public Date getAcquirerTimestamp() {
		return acquirerTimestamp;
	}

	public void setAcquirerTimestamp(Date acquirerTimestamp) {
		this.acquirerTimestamp = acquirerTimestamp;
	}

	public long getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(long paymentID) {
		this.paymentID = paymentID;
	}

	public long getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(long merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public long getId() {
		return id;
	}

	

	
	
}
