package InsurancePOSService.demo.models;

public class HomeInsurance {
	
	private long id; 
	
	private String homeOwner;

	private int insuranceLength;

	public HomeInsurance(long id, String homeOwner, int insuranceLength) {
		super();
		this.id = id;
		this.homeOwner = homeOwner;
		this.insuranceLength = insuranceLength;
	}

	public HomeInsurance(String homeOwner, int insuranceLength) {
		super();
		this.homeOwner = homeOwner;
		this.insuranceLength = insuranceLength;
	}
	
	public HomeInsurance() {
		super();
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

	public void setId(long id) {
		this.id = id;
	}
	
}
