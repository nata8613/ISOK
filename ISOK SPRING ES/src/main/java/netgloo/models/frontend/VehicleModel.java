package netgloo.models.frontend;

public class VehicleModel {
	
	private String ownerName;
	private String ownerSurname;
	private String ownerJmbg;
	private String brandAndType;
	private String productionYear;
	private String registration;
	private String chassis;
	private String totalPrice;
	
	
	private String repairPrice;
	private String hotelDays;
	private String altVehicle;
	private String transportKm;
	
	public VehicleModel() {
		super();
	}
	public VehicleModel(String ownerName, String ownerSurname, String ownerJmbg, String brandAndType,
			String productionYear, String registration, String chassis, String totalPrice , 
			String repairPrice, String hoteldays, String altVehicle, String transportKm) {
		super();
		this.ownerName = ownerName;
		this.ownerSurname = ownerSurname;
		this.ownerJmbg = ownerJmbg;
		this.brandAndType = brandAndType;
		this.productionYear = productionYear;
		this.registration = registration;
		this.chassis = chassis;
		this.totalPrice = totalPrice;
		
		this.repairPrice = repairPrice;
		this.hotelDays = hoteldays;
		this.altVehicle = altVehicle;
		this.transportKm = transportKm;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerSurname() {
		return ownerSurname;
	}
	public void setOwnerSurname(String ownerSurname) {
		this.ownerSurname = ownerSurname;
	}
	public String getOwnerJmbg() {
		return ownerJmbg;
	}
	public void setOwnerJmbg(String ownerJmbg) {
		this.ownerJmbg = ownerJmbg;
	}
	public String getBrandAndType() {
		return brandAndType;
	}
	public void setBrandAndType(String brandAndType) {
		this.brandAndType = brandAndType;
	}
	public String getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getChassis() {
		return chassis;
	}
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getRepairPrice() {
		return repairPrice;
	}
	public void setRepairPrice(String repairPrice) {
		this.repairPrice = repairPrice;
	}
	public String getHotelDays() {
		return hotelDays;
	}
	public void setHotelDays(String hotelDays) {
		this.hotelDays = hotelDays;
	}
	public String getAltVehicle() {
		return altVehicle;
	}
	public void setAltVehicle(String altVehicle) {
		this.altVehicle = altVehicle;
	}
	public String getTransportKm() {
		return transportKm;
	}
	public void setTransportKm(String transportKm) {
		this.transportKm = transportKm;
	}
	
	
}
