package InsurancePOSService.demo.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import InsurancePOSService.demo.models.CarInsuranceDTO;
import InsurancePOSService.demo.models.Client;
import InsurancePOSService.demo.models.HomeInsurance;
import InsurancePOSService.demo.models.HomeInsuranceDTO;
import InsurancePOSService.demo.models.Person;
import InsurancePOSService.demo.models.Policy;
import InsurancePOSService.demo.models.PolicyDTO;
import InsurancePOSService.demo.models.RiskItem;
import InsurancePOSService.demo.models.TravelInsurance;
import InsurancePOSService.demo.models.TravelInsuranceDTO;
import InsurancePOSService.demo.models.VehicleInsurance;

@Controller
@RequestMapping("/policy")
@CrossOrigin("*")
public class PolicyController {

	private String urlBase;
	private RestTemplate rest;
	private HttpHeaders headers;
	private Map<String, Object> params;
	private HttpEntity<Map<String, Object>> requestEntity;
	
	public PolicyController(){
		urlBase = "http://localhost:8080/dc/isok/";
		rest = new RestTemplate();
		headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");
	    headers.add("Accept", "*/*");
		params = new HashMap<String, Object>();
	}
	
	@RequestMapping(value="/savePolicy", method=RequestMethod.POST)
	public ResponseEntity<String> savePolicy(@RequestBody PolicyDTO policy) {
		
		TravelInsuranceDTO travelInsDTO = policy.getTravelInsurance();
		HomeInsuranceDTO homeInsDTO = policy.getHomeInsurance();
		CarInsuranceDTO carInsDTO = policy.getCarInsurance();
		List<Person> people = policy.getPeople();
		
		Policy policyDal = new Policy();
		Set<Client> clients = new HashSet<Client>();
		Client insuranceOwner = new Client();
		Set<RiskItem> riskItems = new HashSet<RiskItem>();
		
		for(Person p : people){
			if(p.getEmail()!=null && !p.getEmail().trim().isEmpty()){
				insuranceOwner = new Client(p.getFirstName(), p.getLastName(), p.getPassportNumber(), p.getJmbg(), p.getAddress(), p.getTelNum(), p.getEmail(), null, null);
			}
			else
				clients.add(new Client(p.getFirstName(), p.getLastName(), p.getPassportNumber(), p.getJmbg(), p.getAddress(), p.getTelNum(), p.getEmail(), null, null));
		}
		TravelInsurance travelIns = new TravelInsurance(insuranceOwner.getClientEmail(), travelInsDTO.getNumberOfPeople(), 300);	// THIS PRICE
		HttpEntity<TravelInsurance> requestEntity= new HttpEntity<TravelInsurance>(travelIns, this.headers);		
		TravelInsurance travelInsNew = (TravelInsurance) rest.postForObject(this.urlBase+"saveTravelInsurance/", requestEntity, TravelInsurance.class);

		if(homeInsDTO!=null){
			HomeInsurance homeIns = new HomeInsurance(homeInsDTO.getFirstName(), homeInsDTO.getLastName(), String.valueOf(homeInsDTO.getJmbg()), homeInsDTO.getInsuranceLength());
			HttpEntity<HomeInsurance> requestEntity2 = new HttpEntity<HomeInsurance>(homeIns, this.headers);
			HomeInsurance homeInsNew = (HomeInsurance) rest.postForObject(this.urlBase+"saveHomeIns/", requestEntity2, HomeInsurance.class);
			riskItems.add(getRiskItemById(homeInsDTO.getHomeAge()));
			riskItems.add(getRiskItemById(homeInsDTO.getHomeSurface()));
			riskItems.add(getRiskItemById(homeInsDTO.getHomeValue()));
			riskItems.add(getRiskItemById(homeInsDTO.getInsuranceReason()));
			policyDal.setHomeInsurance(homeInsNew);
		}
		if(carInsDTO.getTypeOfVehicle()!=null && carInsDTO.getYearOfProduction()!=0){
			VehicleInsurance carIns  = new VehicleInsurance(carInsDTO.getTypeOfVehicle(), String.valueOf(carInsDTO.getYearOfProduction()), carInsDTO.getRegTable(), carInsDTO.getChassisNumber(), carInsDTO.getFirstName(), carInsDTO.getLastName(), carInsDTO.getJmbg());	
			HttpEntity<VehicleInsurance> requestEntity3 = new HttpEntity<VehicleInsurance>(carIns, this.headers);
			VehicleInsurance carInsNew = (VehicleInsurance) rest.postForObject(this.urlBase+"saveVehicleInsurance/", requestEntity3, VehicleInsurance.class);
			if(carInsDTO.getRepairPrice()!="")
				riskItems.add(getRiskItemById(carInsDTO.getRepairPrice()));
			if(carInsDTO.getNumberOfHotelDays()!="")
				riskItems.add(getRiskItemById(carInsDTO.getNumberOfHotelDays()));
			if(carInsDTO.getAlternativeVehicle()!="")
				riskItems.add(getRiskItemById(carInsDTO.getAlternativeVehicle()));
			if(carInsDTO.getNumberOfKm()!="")	
				riskItems.add(getRiskItemById(carInsDTO.getNumberOfKm()));
			policyDal.setVehicleInsurance(carInsNew);
		}
		Set<Client> clientsIds = new HashSet<Client>();
		for(Client c : clients){
			HttpEntity<Client> requestEntity4 = new HttpEntity<Client>(c, this.headers);
			Client clientNew = (Client) rest.postForObject(this.urlBase+"saveClient/", requestEntity4, Client.class);
			clientsIds.add(clientNew);
		}
		
		HttpEntity<Client> requestEntity4 = new HttpEntity<Client>(insuranceOwner, this.headers);
		Client insuranceOwnerNew = (Client) rest.postForObject(this.urlBase+"saveClient/", requestEntity4, Client.class);
		clientsIds.add(insuranceOwnerNew);
		
		policyDal.setClients(clientsIds);
		policyDal.setContractStart(travelInsDTO.getStartingDate());
		policyDal.setContractEnd(travelInsDTO.getEndingDate());
		policyDal.setInsuranceOwner(insuranceOwnerNew);
		double priceSummed = policy.getPriceCar() + policy.getPriceHome() + policy.getPriceTravel();
		policyDal.setPriceSummed(priceSummed);
		policyDal.setTravelInsurance(travelInsNew);

		riskItems.add(getRiskItemById(travelInsDTO.getAges()));
		riskItems.add(getRiskItemById(travelInsDTO.getRegion()));
		if(travelInsDTO.getSport()!="")
			riskItems.add(getRiskItemById(travelInsDTO.getSport()));
		riskItems.add(getRiskItemById(travelInsDTO.getAmmount()));

		
		policyDal.setRiskItems(riskItems);
		HttpEntity<Policy> requestEntity5 = new HttpEntity<Policy>(policyDal, this.headers);
		Policy response = (Policy)rest.postForObject(this.urlBase+"savePolicy/", requestEntity5, Policy.class);
		System.out.println("Response is " + response.getPriceSummed());
		return ResponseEntity.ok(new String("OK"));
		
	}
	
	private RiskItem getRiskItemById(String id){
		this.params.put("id", id);
		this.requestEntity = new HttpEntity<Map<String, Object>>(this.params, this.headers);
		RiskItem item = (RiskItem)rest.postForObject(this.urlBase+"getRiskItem/", this.requestEntity, RiskItem.class);
		return item;
	}
}
