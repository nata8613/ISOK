package com.PaymentHandler.PaymentHandler.models;

import java.sql.Date;

public class DataAcqToPH {
	private long merchantOrderId;
	private long acquirerOrderId;
	private Date acquirerTimestamp;
	private long paymentId;
	private String result;
	
	public DataAcqToPH() {
		
	}

	public DataAcqToPH(long merchantOrderId, long acquirerOrderId, Date acquirerTimestamp, long paymentId,
			String result) {
		super();
		this.merchantOrderId = merchantOrderId;
		this.acquirerOrderId = acquirerOrderId;
		this.acquirerTimestamp = acquirerTimestamp;
		this.paymentId = paymentId;
		this.result = result;
	}

	public long getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(long merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public long getAcquirerOrderId() {
		return acquirerOrderId;
	}

	public void setAcquirerOrderId(long acquirerOrderId) {
		this.acquirerOrderId = acquirerOrderId;
	}

	public Date getAcquirerTimestamp() {
		return acquirerTimestamp;
	}

	public void setAcquirerTimestamp(Date acquirerTimestamp) {
		this.acquirerTimestamp = acquirerTimestamp;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	} 
}
