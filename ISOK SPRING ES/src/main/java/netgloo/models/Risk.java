package netgloo.models;

import java.util.HashSet;
import java.util.Set;

public class Risk {

	private long id; 
	
	private String riskName;

	private Set<RiskItem> riskItems = new HashSet<RiskItem>();

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public Set<RiskItem> getRiskItems() {
		return riskItems;
	}

	public void setRiskItems(Set<RiskItem> riskItems) {
		this.riskItems = riskItems;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Risk(long id, String riskName, Set<RiskItem> riskItems) {
		super();
		this.id = id;
		this.riskName = riskName;
		this.riskItems = riskItems;
	}

	public Risk() {
		super();
	}
	
	
}
