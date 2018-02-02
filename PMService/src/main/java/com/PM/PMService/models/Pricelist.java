package com.PM.PMService.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class Pricelist {
	
	private long id;

	private Date validFrom;
	
	private Date validTo;
	
	private Set<PriceImpacts> impacts = new HashSet<PriceImpacts>();

	public Pricelist() {
		super();
	}

	public Pricelist(Date validFrom, Date validTo, Set<PriceImpacts> impacts) {
		super();
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.impacts = impacts;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Set<PriceImpacts> getImpacts() {
		return impacts;
	}

	public void setImpacts(Set<PriceImpacts> impacts) {
		this.impacts = impacts;
	}

	public long getId() {
		return id;
	}

	
	
}