package datacentar.dc.isok.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "policyRiskItem")
@IdClass(PolicyRiskItemID.class)
public class Policy_RiskItem {
	
	@Id
	private long riskItemID;
	
	@Id
	private long policyID;

	public Policy_RiskItem() {
		super();
	}

	public long getRiskItemID() {
		return riskItemID;
	}

	public void setRiskItemID(long riskItemID) {
		this.riskItemID = riskItemID;
	}

	public long getPolicyID() {
		return policyID;
	}

	public void setPolicyID(long policyID) {
		this.policyID = policyID;
	}

}
