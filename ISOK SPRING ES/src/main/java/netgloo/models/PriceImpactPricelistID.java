package netgloo.models;

import java.io.Serializable;

public class PriceImpactPricelistID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long pricelistID;

	long priceImpactID;

	public PriceImpactPricelistID() {
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
