package netgloo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "insuranceCategory_Risk")
@IdClass(InsuranceCategoryRiskID.class)
public class InsuranceCategory_Risk {
	

	@Id
	private long insuranceCategoryID;
	
	@Id
	private long riskID;


	public InsuranceCategory_Risk() {
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
