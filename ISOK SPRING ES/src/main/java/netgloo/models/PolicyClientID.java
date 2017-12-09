package netgloo.models;

import java.io.Serializable;

public class PolicyClientID implements Serializable{
	
	private static final long serialVersionUID = 1L;

	long clientID;

	long policyID;

	public PolicyClientID() {
		super();
	}

	public long getClientID() {
		return clientID;
	}

	public void setClientID(long clientID) {
		this.clientID = clientID;
	}

	public long getPolicyID() {
		return policyID;
	}

	public void setPolicyID(long policyID) {
		this.policyID = policyID;
	}
	
	
}
