package InsurancePOSService.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Policy {

	private long id;
	
	private TravelInsurance travelInsurance;

	private HomeInsurance homeInsurance;

	private VehicleInsurance vehicleInsurance;

	private Set<RiskItem> riskItems = new HashSet<RiskItem>();

	private Client insuranceOwner;
	
	private Set<Client> clients = new HashSet<Client>();
	
	private double priceSummed;

	private Date contractStart;

	private Date contractEnd;

	public Policy(long id,TravelInsurance travelInsurance, HomeInsurance homeInsurance, VehicleInsurance vehicleInsurance, Set<RiskItem> riskItems,
			Client insuranceOwner, Set<Client> clients, double priceSummed, Date contractStart, Date contractEnd) {
		super();
		this.id = id;
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
	
	public Policy(TravelInsurance travelInsurance, HomeInsurance homeInsurance, VehicleInsurance vehicleInsurance, Set<RiskItem> riskItems,
			Client insuranceOwner, Set<Client> clients, double priceSummed, Date contractStart, Date contractEnd) {
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

	public Set<RiskItem> getRiskItems() {
		return riskItems;
	}

	public void setRiskItems(Set<RiskItem> riskItems) {
		this.riskItems = riskItems;
	}

	public Client getInsuranceOwner() {
		return insuranceOwner;
	}

	public void setInsuranceOwner(Client insuranceOwner) {
		this.insuranceOwner = insuranceOwner;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
}
