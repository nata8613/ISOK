package com.Acquirer.Acquirer.models;

import java.sql.Date;

public class DataAcqToPCC {

	private long acquirerOrderId;
	private Date acquirerTimestamp;
	private long PAN;
	private int secuityCode;
	private String cardHolderName;
	private Date validDate;
	private double amount;
	
	public DataAcqToPCC() {
		
	}

	public DataAcqToPCC(long acquirerOrderId, Date acquirerTimestamp, long pAN, int secuityCode, String cardHolderName,
			Date validDate, double amount) {
		super();
		this.acquirerOrderId = acquirerOrderId;
		this.acquirerTimestamp = acquirerTimestamp;
		PAN = pAN;
		this.secuityCode = secuityCode;
		this.cardHolderName = cardHolderName;
		this.validDate = validDate;
		this.amount = amount;
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

	public long getPAN() {
		return PAN;
	}

	public void setPAN(long pAN) {
		PAN = pAN;
	}

	public int getSecuityCode() {
		return secuityCode;
	}

	public void setSecuityCode(int secuityCode) {
		this.secuityCode = secuityCode;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
