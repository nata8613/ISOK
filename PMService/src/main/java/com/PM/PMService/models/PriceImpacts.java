package com.PM.PMService.models;

import java.util.HashSet;
import java.util.Set;




public class PriceImpacts {

	private long id;
	
	private double value;
	
	private RiskItem item;

	private Set<Pricelist> pricelists = new HashSet<Pricelist>();
	
	public PriceImpacts() {
		super();
	}

	public PriceImpacts(double value, RiskItem item, Set<Pricelist> pricelists) {
		super();
		this.value = value;
		this.item = item;
		this.pricelists = pricelists;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public RiskItem getItem() {
		return item;
	}

	public void setItem(RiskItem item) {
		this.item = item;
	}

	public Set<Pricelist> getPricelists() {
		return pricelists;
	}

	public void setPricelists(Set<Pricelist> pricelists) {
		this.pricelists = pricelists;
	}

	public long getId() {
		return id;
	}
	
	
}
