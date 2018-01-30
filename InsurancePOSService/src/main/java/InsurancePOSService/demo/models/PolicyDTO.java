package InsurancePOSService.demo.models;

import java.util.List;

public class PolicyDTO {

	private TravelInsuranceDTO travelInsurance;
	private List<Person> people;
	private HomeInsuranceDTO homeInsurance;
	private CarInsuranceDTO carInsurance;
	private double priceCar;
	private double priceHome;
	private double priceTravel;
	
	
	public PolicyDTO(TravelInsuranceDTO travelInsurance, List<Person> people, HomeInsuranceDTO homeInsurance,
			CarInsuranceDTO carInsurance, double priceCar, double priceHome, double priceTravel) {
		super();
		this.travelInsurance = travelInsurance;
		this.people = people;
		this.homeInsurance = homeInsurance;
		this.carInsurance = carInsurance;
		this.priceCar = priceCar;
		this.priceHome = priceHome;
		this.priceTravel = priceTravel;
	}
	public PolicyDTO() {
		super();
	}
	public TravelInsuranceDTO getTravelInsurance() {
		return travelInsurance;
	}
	public void setTravelInsurance(TravelInsuranceDTO travelInsurance) {
		this.travelInsurance = travelInsurance;
	}
	public List<Person> getPeople() {
		return people;
	}
	public void setPeople(List<Person> people) {
		this.people = people;
	}
	public HomeInsuranceDTO getHomeInsurance() {
		return homeInsurance;
	}
	public void setHomeInsurance(HomeInsuranceDTO homeInsurance) {
		this.homeInsurance = homeInsurance;
	}
	public CarInsuranceDTO getCarInsurance() {
		return carInsurance;
	}
	public void setCarInsurance(CarInsuranceDTO carInsurance) {
		this.carInsurance = carInsurance;
	}
	public double getPriceCar() {
		return priceCar;
	}
	public void setPriceCar(double priceCar) {
		this.priceCar = priceCar;
	}
	public double getPriceHome() {
		return priceHome;
	}
	public void setPriceHome(double priceHome) {
		this.priceHome = priceHome;
	}
	public double getPriceTravel() {
		return priceTravel;
	}
	public void setPriceTravel(double priceTravel) {
		this.priceTravel = priceTravel;
	}
	
	
	
}
