package netgloo.models;

import java.util.HashSet;
import java.util.Set;

public class PriceImpacts {
	
	private long id;
	
	private double value;

	private RiskItem item;
	
	private Set<PriceList> PriceLists = new HashSet<PriceList>();

	public PriceImpacts(long id, double value, RiskItem item,
			Set<PriceList> priceLists) {
		super();
		this.id = id;
		this.value = value;
		this.item = item;
		PriceLists = priceLists;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Set<PriceList> getPriceLists() {
		return PriceLists;
	}

	public void setPriceLists(Set<PriceList> priceLists) {
		PriceLists = priceLists;
	}

	public PriceImpacts() {
		super();
	}

	
	
	
}
