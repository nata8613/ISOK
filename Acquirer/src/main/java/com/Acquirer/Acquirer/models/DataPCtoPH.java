package com.Acquirer.Acquirer.models;



public class DataPCtoPH {
	private MerchLicense merchantLicense;
	private Order order;
	private String error_url;
	
	public DataPCtoPH() {
		
	}

	public DataPCtoPH(MerchLicense merchantLicense, Order order,String error_url) {
		super();
		this.merchantLicense = merchantLicense;
		this.order = order;
		this.error_url = error_url;
	}

	public MerchLicense getMerchantLicense() {
		return merchantLicense;
	}

	public void setMerchantLicense(MerchLicense merchantLicense) {
		this.merchantLicense = merchantLicense;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getError_url() {
		return error_url;
	}

	public void setError_url(String error_url) {
		this.error_url = error_url;
	}
}
