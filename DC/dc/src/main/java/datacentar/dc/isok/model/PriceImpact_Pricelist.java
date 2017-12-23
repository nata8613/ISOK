package datacentar.dc.isok.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "priceImpactPricelist")
@IdClass(PriceImpactPricelistID.class)
public class PriceImpact_Pricelist {

	@Id
	private long pricelistID;
	
	@Id
	private long priceImpactID;

	public PriceImpact_Pricelist() {
		super();
	}

	public long getPricelistID() {
		return pricelistID;
	}

	public void setPricelistID(long pricelistID) {
		this.pricelistID = pricelistID;
	}

	public long getPriceImpactID() {
		return priceImpactID;
	}

	public void setPriceImpactID(long priceImpactID) {
		this.priceImpactID = priceImpactID;
	}

}
