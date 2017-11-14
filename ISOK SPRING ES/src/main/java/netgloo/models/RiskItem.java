package netgloo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "riskItem")
public class RiskItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String itemName;
	
	@NotNull
	private long riskID;

	public RiskItem() {
		super();
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public long getRiskID() {
		return riskID;
	}

	public void setRiskID(long riskID) {
		this.riskID = riskID;
	}

	public long getId() {
		return id;
	}
	
	
}
