package netgloo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "policy")
public class Policy {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private long homeInsuranceID;
	

	@NotNull
	private double priceSummed;


	public Policy() {
		super();
	}


	public long getHomeInsuranceID() {
		return homeInsuranceID;
	}


	public void setHomeInsuranceID(long homeInsuranceID) {
		this.homeInsuranceID = homeInsuranceID;
	}


	public double getPriceSummed() {
		return priceSummed;
	}


	public void setPriceSummed(double priceSummed) {
		this.priceSummed = priceSummed;
	}


	public long getId() {
		return id;
	}
	
	
}
