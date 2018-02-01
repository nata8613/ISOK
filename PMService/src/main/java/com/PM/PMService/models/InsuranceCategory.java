package com.PM.PMService.models;

import java.util.HashSet;
import java.util.Set;


public class InsuranceCategory {
	
	private long id;

	private String categoryName;
	
	private double startingPrice;
	
	private double clientFee;

	private Set<Risk> risks = new HashSet<Risk>();

	public InsuranceCategory() {
		
	}

	public InsuranceCategory(String categoryName, double startingPrice, double clientFee, Set<Risk> risks) {
		super();
		this.categoryName = categoryName;
		this.startingPrice = startingPrice;
		this.clientFee = clientFee;
		this.risks = risks;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public Set<Risk> getRisks() {
		return risks;
	}


	public void setRisks(Set<Risk> risks) {
		this.risks = risks;
	}


	public long getId() {
		return id;
	}


	public double getStartingPrice() {
		return startingPrice;
	}


	public void setStartingPrice(double startingPrice) {
		this.startingPrice = startingPrice;
	}


	public double getClientFee() {
		return clientFee;
	}


	public void setClientFee(double clientFee) {
		this.clientFee = clientFee;
	}


	
	
}
