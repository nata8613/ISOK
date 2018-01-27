package InsurancePOSService.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Policy {

	private TravelInsurance travelInsurance;

	private HomeInsurance homeInsurance;

	private VehicleInsurance vehicleInsurance;

	private Set<Long> riskItems = new HashSet<Long>();

	private long insuranceOwner;
	
	private Set<Long> clients = new HashSet<Long>();
	
	private double priceSummed;

	private Date contractStart;

	private Date contractEnd;

	public Policy(TravelInsurance travelInsurance, HomeInsurance homeInsurance, VehicleInsurance vehicleInsurance, Set<Long> riskItems,
			long insuranceOwner, Set<Long> clients, double priceSummed, Date contractStart, Date contractEnd) {
		super();
		this.travelInsurance = travelInsurance;
		this.homeInsurance = homeInsurance;
		this.vehicleInsurance = vehicleInsurance;
		this.riskItems = riskItems;
		this.insuranceOwner = insuranceOwner;
		this.clients = clients;
		this.priceSummed = priceSummed;
		this.contractStart = contractStart;
		this.contractEnd = contractEnd;
	}

	public Policy() {
		super();
	}


	public TravelInsurance getTravelInsurance() {
		return travelInsurance;
	}

	public void setTravelInsurance(TravelInsurance travelInsurance) {
		this.travelInsurance = travelInsurance;
	}

	public HomeInsurance getHomeInsurance() {
		return homeInsurance;
	}

	public void setHomeInsurance(HomeInsurance homeInsurance) {
		this.homeInsurance = homeInsurance;
	}

	public VehicleInsurance getVehicleInsurance() {
		return vehicleInsurance;
	}

	public void setVehicleInsurance(VehicleInsurance vehicleInsurance) {
		this.vehicleInsurance = vehicleInsurance;
	}

	public Set<Long> getRiskItems() {
		return riskItems;
	}

	public void setRiskItems(Set<Long> riskItems) {
		this.riskItems = riskItems;
	}

	public long getInsuranceOwner() {
		return insuranceOwner;
	}

	public void setInsuranceOwner(long insuranceOwner) {
		this.insuranceOwner = insuranceOwner;
	}

	public Set<Long> getClients() {
		return clients;
	}

	public void setClients(Set<Long> clients) {
		this.clients = clients;
	}

	public double getPriceSummed() {
		return priceSummed;
	}

	public void setPriceSummed(double priceSummed) {
		this.priceSummed = priceSummed;
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
