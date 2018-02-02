package com.PaymentHandler.PaymentHandler.models;

public class MerchLicense {

	private long id;
	private String merchantId;
	private String merchantPassword;
	
	public MerchLicense() {
		
	}

	public MerchLicense(String merchantId, String merchantPassword) {
		super();
		this.merchantId = merchantId;
		this.merchantPassword = merchantPassword;
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

	public long getId() {
		return id;
	}
	
	
}
