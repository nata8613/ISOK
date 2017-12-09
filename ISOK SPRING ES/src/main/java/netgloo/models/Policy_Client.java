package netgloo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "policyClient")
@IdClass(PolicyClientID.class)
public class Policy_Client {
	
	@Id
	private long clientID;
	
	@Id
	private long policyID;

	public Policy_Client() {
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
