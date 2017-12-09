package netgloo.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name = "policy")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private long travelInsuranceID;

	@Null
	private long homeInsuranceID;

	@Null
	private long vehicleInsuranceID;

	@NotNull
	private double priceSummed;

	@NotNull
	private Date contractStart;

	@NotNull
	private Date contractEnd;

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

	public long getTravelInsuranceID() {
		return travelInsuranceID;
	}

	public void setTravelInsuranceID(long travelInsuranceID) {
		this.travelInsuranceID = travelInsuranceID;
	}

	public long getVehicleInsuranceID() {
		return vehicleInsuranceID;
	}

	public void setVehicleInsuranceID(long vehicleInsuranceID) {
		this.vehicleInsuranceID = vehicleInsuranceID;
	}

	public Date getContractStart() {
		return contractStart;
	}

	public void setContractStart(Date contractStart) {
		this.contractStart = contractStart;
	}

	public Date getContractEnd() {
		return contractEnd;
	}

	public void setContractEnd(Date contractEnd) {
		this.contractEnd = contractEnd;
	}

}
