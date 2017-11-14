package netgloo.models;

import java.io.Serializable;

public class PolicyRiskItemID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long riskItemID;

	long policyID;

	public PolicyRiskItemID() {
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
