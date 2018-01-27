package InsurancePOSService.demo.models;

import java.util.List;

public class PolicyDTO {

	private TravelInsuranceDTO travelInsurance;
	private List<Person> people;
	private HomeInsuranceDTO homeInsurance;
	private CarInsuranceDTO carInsurance;
	
	public PolicyDTO(TravelInsuranceDTO travelInsurance, List<Person> people, HomeInsuranceDTO homeInsurance,
			CarInsuranceDTO carInsurance) {
		super();
		this.travelInsurance = travelInsurance;
		this.people = people;
		this.homeInsurance = homeInsurance;
		this.carInsurance = carInsurance;
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
	
	
	
}
