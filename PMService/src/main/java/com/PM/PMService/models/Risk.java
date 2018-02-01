package com.PM.PMService.models;


import java.util.HashSet;
import java.util.Set;


public class Risk {
	
	private long id;
	
	private String riskName;
	
	private Set<RiskItem> riskItems = new HashSet<RiskItem>();
	
	private Set<InsuranceCategory> categories = new HashSet<InsuranceCategory>();

	public Risk() {
	}

	
	public Risk(String riskName, Set<com.PM.PMService.models.RiskItem> riskItems,
			Set<InsuranceCategory> categories) {
		super();
		this.riskName = riskName;
		this.riskItems = riskItems;
		this.categories = categories;
	}


	public long getId() {
		return id;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}


	public Set<RiskItem> getRiskItems() {
		return riskItems;
	}


	public void setRiskItems(Set<RiskItem> riskItems) {
		this.riskItems = riskItems;
	}


	public Set<InsuranceCategory> getCategories() {
		return categories;
	}


	public void setCategories(Set<InsuranceCategory> categories) {
		this.categories = categories;
	}

}
