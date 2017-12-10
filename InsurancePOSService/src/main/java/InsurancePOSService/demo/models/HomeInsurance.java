package InsurancePOSService.demo.models;

public class HomeInsurance {

	private String firstName;
	private String lastName;
	private String address;
	private int jmbg;
	private String homeSurface;
	private String homeAge;
	private String homeValue;
	private String insuranceReason;
	private int insuranceLength;
	
	public HomeInsurance() {
		super();
	}
	public HomeInsurance(String firstName, String lastName, String address, int jmbg, String homeSurface,
			String homeAge, String homeValue, String insuranceReason, int insuranceLength) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.jmbg = jmbg;
		this.homeSurface = homeSurface;
		this.homeAge = homeAge;
		this.homeValue = homeValue;
		this.insuranceReason = insuranceReason;
		this.insuranceLength = insuranceLength;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getJmbg() {
		return jmbg;
	}
	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}
	public String getHomeSurface() {
		return homeSurface;
	}
	public void setHomeSurface(String homeSurface) {
		this.homeSurface = homeSurface;
	}
	public String getHomeAge() {
		return homeAge;
	}
	public void setHomeAge(String homeAge) {
		this.homeAge = homeAge;
	}
	public String getHomeValue() {
		return homeValue;
	}
	public void setHomeValue(String homeValue) {
		this.homeValue = homeValue;
	}
	public String getInsuranceReason() {
		return insuranceReason;
	}
	public void setInsuranceReason(String insuranceReason) {
		this.insuranceReason = insuranceReason;
	}
	public int getInsuranceLength() {
		return insuranceLength;
	}
	public void setInsuranceLength(int insuranceLength) {
		this.insuranceLength = insuranceLength;
	}
	
	
}