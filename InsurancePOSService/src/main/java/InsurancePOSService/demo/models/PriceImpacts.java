package InsurancePOSService.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PriceImpacts {
	
	private long id;
	
	private double value;
	
	private Date validFrom;
	
	private Date validTo;
	
	private Set<PriceList> PriceLists = new HashSet<PriceList>();

	public PriceImpacts(long id, double value, Date validFrom, Date validTo, Set<PriceList> PriceLists) {
		super();
		this.id = id;
		this.value = value;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.PriceLists = PriceLists;
	}

	public PriceImpacts() {
		super();
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

	public Set<PriceList> getPriceLists() {
		return PriceLists;
	}

	public void setPriceLists(Set<PriceList> PriceLists) {
		this.PriceLists = PriceLists;
	}
	
	
}
