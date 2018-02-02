package com.PaymentHandler.PaymentHandler.models;

import java.sql.Date;

public class Transaction {

	
	private long transactionId;

	
	private long merchantOrderId;
	
	private Date merchantOrderTimestamp;
	
	private long acquirerOrderId;

	private Date acquirerOrderTimestamp;

	
	private long paymentId; 

	
	private long amount;
	
	private String status;

	public Transaction() {
		super();
	}

	
	public Transaction(long merchantOrderId, Date merchantOrderTimestamp, long acquirerOrderId,
			Date acquirerOrderTimestamp, long paymentId, long amount, String status) {
		super();
		this.merchantOrderId = merchantOrderId;
		this.merchantOrderTimestamp = merchantOrderTimestamp;
		this.acquirerOrderId = acquirerOrderId;
		this.acquirerOrderTimestamp = acquirerOrderTimestamp;
		this.paymentId = paymentId;
		this.amount = amount;
		this.status = status;
	}


	public long getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(long merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public Date getMerchantOrderTimestamp() {
		return merchantOrderTimestamp;
	}

	public void setMerchantOrderTimestamp(Date merchantOrderTimestamp) {
		this.merchantOrderTimestamp = merchantOrderTimestamp;
	}

	public long getAcquirerOrderId() {
		return acquirerOrderId;
	}

	public void setAcquirerOrderId(long acquirerOrderId) {
		this.acquirerOrderId = acquirerOrderId;
	}

	public Date getAcquirerOrderTimestamp() {
		return acquirerOrderTimestamp;
	}

	public void setAcquirerOrderTimestamp(Date acquirerOrderTimestamp) {
		this.acquirerOrderTimestamp = acquirerOrderTimestamp;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getTransactionId() {
		return transactionId;
	}

}
