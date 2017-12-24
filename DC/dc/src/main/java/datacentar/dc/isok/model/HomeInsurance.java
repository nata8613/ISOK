package datacentar.dc.isok.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "homeInsurance")
public class HomeInsurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String homeOwner;

	@NotNull
	private int insuranceLength;

	
	public HomeInsurance() {
		super();
	}

	public HomeInsurance(String homeOwner, int insuranceLength) {
		super();
		this.homeOwner = homeOwner;
		this.insuranceLength = insuranceLength;
	}

	public String getHomeOwner() {
		return homeOwner;
	}

	public void setHomeOwner(String homeOwner) {
		this.homeOwner = homeOwner;
	}

	public int getInsuranceLength() {
		return insuranceLength;
	}

	public void setInsuranceLength(int insuranceLength) {
		this.insuranceLength = insuranceLength;
	}

	public long getId() {
		return id;
	}

}
