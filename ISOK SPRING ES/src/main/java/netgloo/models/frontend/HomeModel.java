package netgloo.models.frontend;

public class HomeModel {
	
	private String ownerName;
	private String ownerJmbg;
	private String homeAddress;
	private String homeAge;
	private String homeSurface;
	private String homeValue;
	private String insuranceType;
	private String totalPrice;
	public HomeModel() {
		super();
	}
	public HomeModel(String ownerName, String ownerJmbg, String homeAddress, String homeAge, String homeSurface,
			String homeValue, String insuranceType, String totalPrice) {
		super();
		this.ownerName = ownerName;
		this.ownerJmbg = ownerJmbg;
		this.homeAddress = homeAddress;
		this.homeAge = homeAge;
		this.homeSurface = homeSurface;
		this.homeValue = homeValue;
		this.insuranceType = insuranceType;
		this.totalPrice = totalPrice;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerJmbg() {
		return ownerJmbg;
	}
	public void setOwnerJmbg(String ownerJmbg) {
		this.ownerJmbg = ownerJmbg;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getHomeAge() {
		return homeAge;
	}
	public void setHomeAge(String homeAge) {
		this.homeAge = homeAge;
	}
	public String getHomeSurface() {
		return homeSurface;
	}
	public void setHomeSurface(String homeSurface) {
		this.homeSurface = homeSurface;
	}
	public String getHomeValue() {
		return homeValue;
	}
	public void setHomeValue(String homeValue) {
		this.homeValue = homeValue;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
