package InsurancePOSService.demo.models;

import java.util.HashSet;
import java.util.Set;

public class RiskItem {

	private String id;
	
	private String itemName;
 
	private Set<PriceImpacts> impacts = new HashSet<PriceImpacts>(); 

	public RiskItem(String id, String itemName,
			Set<InsurancePOSService.demo.models.PriceImpacts> impacts) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.impacts = impacts;
	}

	public RiskItem() {
		super();
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Set<PriceImpacts> getImpacts() {
		return impacts;
	}

	public void setImpacts(Set<PriceImpacts> impacts) {
		this.impacts = impacts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
