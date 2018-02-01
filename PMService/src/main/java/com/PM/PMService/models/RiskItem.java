package com.PM.PMService.models;

import java.util.HashSet;
import java.util.Set;


public class RiskItem {

	private long id;
	
	private String itemName;
	
	private Risk risk;

	private Set<PriceImpacts> impacts = new HashSet<PriceImpacts>(); 
	
	private Set<Policy> policies = new HashSet<Policy>();

	public RiskItem() {
	}

	public RiskItem(String itemName, Risk risk, Set<PriceImpacts> impacts, Set<Policy> policies) {
		super();
		this.itemName = itemName;
		this.risk = risk;
		this.impacts = impacts;
		this.policies = policies;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Risk getRisk() {
		return risk;
	}

	public void setRisk(Risk risk) {
		this.risk = risk;
	}

	public Set<PriceImpacts> getImpacts() {
		return impacts;
	}

	public void setImpacts(Set<PriceImpacts> impacts) {
		this.impacts = impacts;
	}

	public Set<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(Set<Policy> policies) {
		this.policies = policies;
	}

	public long getId() {
		return id;
	}

	
}
