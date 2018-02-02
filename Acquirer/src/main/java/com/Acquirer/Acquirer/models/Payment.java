package com.Acquirer.Acquirer.models;

public class Payment {
	private String paymentURL;
	private long paymentID;
	
	public Payment() {
		
	}

	public Payment(String paymentURL, long paymentID) {
		super();
		this.paymentURL = paymentURL;
		this.paymentID = paymentID;
	}

	public String getPaymentURL() {
		return paymentURL;
	}

	public void setPaymentURL(String paymentURL) {
		this.paymentURL = paymentURL;
	}

	public long getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(long paymentID) {
		this.paymentID = paymentID;
	}
}
