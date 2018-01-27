package InsurancePOSService.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PriceList {

	private long id;

	private Date validFrom;
	 
	private Date validTo; 
	
	private Set<PriceImpacts> impacts = new HashSet<PriceImpacts>();

	public PriceList(long id, Date validFrom, Date validTo, Set<PriceImpacts> impacts) {
		super();
		this.id = id;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.impacts = impacts;
	}

	public PriceList() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	
}
