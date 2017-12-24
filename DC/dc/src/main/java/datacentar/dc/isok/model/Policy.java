package datacentar.dc.isok.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	@OneToOne(cascade = CascadeType.ALL)
	private TravelInsurance travelInsurance;

	@Null
	@OneToOne(cascade = CascadeType.ALL)
	private HomeInsurance homeInsurance;

	@Null
	@OneToOne(cascade = CascadeType.ALL)
	private VehicleInsurance vehicleInsurance;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "policy_riskItem", joinColumns = {
			@JoinColumn(name = "riskItem_id", nullable = false) },
			inverseJoinColumns = { @JoinColumn(name = "policy_id",
					nullable = true) })
	private Set<RiskItem> items = new HashSet<RiskItem>();
	
	/*
	 * @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "role_permission", joinColumns = {
			@JoinColumn(name = "role_id", nullable = false) },
			inverseJoinColumns = { @JoinColumn(name = "permission_id",
					nullable = false) })
	*/
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name="insuranceOwner")
	private Client insuranceOwner;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "policy_client", joinColumns = {
			@JoinColumn(name = "client_id", nullable = false) },
			inverseJoinColumns = { @JoinColumn(name = "policy_id",
					nullable = true) })
	private Set<Client> clients = new HashSet<Client>();
	
	@NotNull
	private double priceSummed;

	@NotNull
	private Date contractStart;

	@NotNull
	private Date contractEnd;

	public Policy() {
		super();
	}

	public Policy(TravelInsurance travelInsurance, HomeInsurance homeInsurance, VehicleInsurance vehicleInsurance,
			Set<RiskItem> riskItems, Client insuranceOwner, Set<Client> clients, double priceSummed, Date contractStart,
			Date contractEnd) {
		super();
		this.travelInsurance = travelInsurance;
		this.homeInsurance = homeInsurance;
		this.vehicleInsurance = vehicleInsurance;
		this.items = riskItems;
		this.insuranceOwner = insuranceOwner;
		this.clients = clients;
		this.priceSummed = priceSummed;
		this.contractStart = contractStart;
		this.contractEnd = contractEnd;
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

	public Set<RiskItem> getRiskItems() {
		return items;
	}

	public void setRiskItems(Set<RiskItem> riskItems) {
		this.items = riskItems;
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


	public double getPriceSummed() {
		return priceSummed;
	}

	public void setPriceSummed(double priceSummed) {
		this.priceSummed = priceSummed;
	}

	public long getId() {
		return id;
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
