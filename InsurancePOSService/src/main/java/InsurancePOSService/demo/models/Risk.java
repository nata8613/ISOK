package InsurancePOSService.demo.models;

import java.util.HashSet;
import java.util.Set;

public class Risk {

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


	public Risk(String riskName, Set<InsurancePOSService.demo.models.RiskItem> riskItems) {
		super();
		this.riskName = riskName;
		this.riskItems = riskItems;
	}

	public Risk() {
		super();
	}
	
	
}
