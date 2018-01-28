package InsurancePOSService.demo.models;

public class CarInsuranceDTO {

	private int insuranceLength;
	private String numberOfKm;
	private String repairPrice;
	private String numberOfHotelDays;
	private String alternativeVehicle;
	private String typeOfVehicle;
	private int yearOfProduction;
	private String regTable;
	private String chassisNumber;
	private String firstName;
	private String lastName;
	private String jmbg;
	
	public CarInsuranceDTO() {
		super();
	}
	public CarInsuranceDTO(int insuranceLength, String numberOfKm, String repairPrice,
			String numberOfHotelDays, String alternativeVehicle, String typeOfVehicle, int yearOfProduction,
			String regTable, String chassisNumber, String firstName, String lastName, String jmbg) {
		super();
		this.insuranceLength = insuranceLength;
		this.numberOfKm = numberOfKm;
		this.repairPrice = repairPrice;
		this.numberOfHotelDays = numberOfHotelDays;
		this.alternativeVehicle = alternativeVehicle;
		this.typeOfVehicle = typeOfVehicle;
		this.yearOfProduction = yearOfProduction;
		this.regTable = regTable;
		this.chassisNumber = chassisNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jmbg = jmbg;
	}
	public int getInsuranceLength() {
		return insuranceLength;
	}
	public void setInsuranceLength(int insuranceLength) {
		this.insuranceLength = insuranceLength;
	}
	public String getNumberOfKm() {
		return numberOfKm;
	}
	public void setNumberOfKm(String numberOfKm) {
		this.numberOfKm = numberOfKm;
	}
	public String getRepairPrice() {
		return repairPrice;
	}
	public void setRepairPrice(String repairPrice) {
		this.repairPrice = repairPrice;
	}
	public String getNumberOfHotelDays() {
		return numberOfHotelDays;
	}
	public void setNumberOfHotelDays(String numberOfHotelDays) {
		this.numberOfHotelDays = numberOfHotelDays;
	}
	public String getAlternativeVehicle() {
		return alternativeVehicle;
	}
	public void setAlternativeVehicle(String alternativeVehicle) {
		this.alternativeVehicle = alternativeVehicle;
	}
	public String getTypeOfVehicle() {
		return typeOfVehicle;
	}
	public void setTypeOfVehicle(String typeOfVehicle) {
		this.typeOfVehicle = typeOfVehicle;
	}
	public int getYearOfProduction() {
		return yearOfProduction;
	}
	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}
	public String getRegTable() {
		return regTable;
	}
	public void setRegTable(String regTable) {
		this.regTable = regTable;
	}
	public String getChassisNumber() {
		return chassisNumber;
	}
	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
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
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	
	
}
