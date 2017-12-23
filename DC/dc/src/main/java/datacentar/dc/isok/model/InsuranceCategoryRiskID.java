package datacentar.dc.isok.model;

import java.io.Serializable;

public class InsuranceCategoryRiskID implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long insuranceCategoryID;
	
	long riskID;

	public InsuranceCategoryRiskID() {
		super();
	}

	public long getInsuranceCategoryID() {
		return insuranceCategoryID;
	}

	public void setInsuranceCategoryID(long insuranceCategoryID) {
		this.insuranceCategoryID = insuranceCategoryID;
	}

	public long getRiskID() {
		return riskID;
	}

	public void setRiskID(long riskID) {
		this.riskID = riskID;
	}
	

}
