package InsurancePOSService.demo.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import InsurancePOSService.demo.models.CarInsuranceDTO;
import InsurancePOSService.demo.models.Client;
import InsurancePOSService.demo.models.HomeInsurance;
import InsurancePOSService.demo.models.HomeInsuranceDTO;
import InsurancePOSService.demo.models.Person;
import InsurancePOSService.demo.models.Policy;
import InsurancePOSService.demo.models.PolicyDTO;
import InsurancePOSService.demo.models.Risk;
import InsurancePOSService.demo.models.RiskItem;
import InsurancePOSService.demo.models.RiskItemDTO;
import InsurancePOSService.demo.models.TravelInsurance;
import InsurancePOSService.demo.models.TravelInsuranceDTO;
import InsurancePOSService.demo.models.VehicleInsurance;

@Controller
@RequestMapping("/carInsurance")
@CrossOrigin("*")
public class CarInsuranceController {
	
	private String urlBase;
	private RestTemplate rest;
	private HttpHeaders headers;
	private Map<String, Object> params;
	private HttpEntity<Map<String, Object>> requestEntity;
	
	public CarInsuranceController(){
		urlBase = "http://localhost:8080/dc/isok/";
		rest = new RestTemplate();
		headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");
	    headers.add("Accept", "*/*");
		params = new HashMap<String, Object>();
	}
	
	@RequestMapping("/getKilometers")
	@ResponseBody
	public List<RiskItemDTO> getKilometers() {
		return this.getRiskByName("Transport km");
	}
	
	@RequestMapping("/getPrices")
	@ResponseBody
	public List<RiskItemDTO> getPrices() {
		return this.getRiskByName("Repair Price");
	}
	
	@RequestMapping("/getHotelDays")
	@ResponseBody
	public List<RiskItemDTO> getHotelDays() {
		return this.getRiskByName("Hotel Days");
	}
	
	@RequestMapping("/getAltVehicle")
	@ResponseBody
	public List<RiskItemDTO> getAltVehicle() {
		return this.getRiskByName("Alt vehicle");
	}
	
	@RequestMapping(value="/createCarInsurance", method=RequestMethod.POST)
	public ResponseEntity<Double> insuranceValue(@RequestBody CarInsuranceDTO insurance) {
		
		// 	TO DO : Na osnovu dobijenih podataka izracunati cenu samo za osiguranje pomoc na putu i vratiti
 		
		return ResponseEntity.ok(new Double(700));
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
		for(Person p : people){
			if(p.getEmail()!=null && !p.getEmail().trim().isEmpty()){
				insuranceOwner = new Client(p.getFirstName(), p.getLastName(), p.getPassportNumber(), p.getJmbg(), p.getAddress(), p.getTelNum(), p.getEmail(), null, null);
				System.out.println("CLIENT EMAIL IS " + p.getEmail());
			}
			clients.add(new Client(p.getFirstName(), p.getLastName(), p.getPassportNumber(), p.getJmbg(), p.getAddress(), p.getTelNum(), p.getEmail(), null, null));
		}
		TravelInsurance travelIns = new TravelInsurance(insuranceOwner.getClientEmail(), travelInsDTO.getNumberOfPeople(), 300);	// THIS PRICE
		HomeInsurance homeIns = new HomeInsurance(String.valueOf(homeInsDTO.getJmbg()), homeInsDTO.getInsuranceLength());
		VehicleInsurance carIns  = new VehicleInsurance(carInsDTO.getTypeOfVehicle(), String.valueOf(carInsDTO.getYearOfProduction()), carInsDTO.getRegTable(), carInsDTO.getChassisNumber(), carInsDTO.getFirstName()+carInsDTO.getLastName()+carInsDTO.getJmbg());
		
		HttpEntity<TravelInsurance> requestEntity= new HttpEntity<TravelInsurance>(travelIns, this.headers);		
		TravelInsurance travelInsNew = (TravelInsurance) rest.postForObject(this.urlBase+"saveTravelInsurance/", requestEntity, TravelInsurance.class);

		HttpEntity<HomeInsurance> requestEntity2 = new HttpEntity<HomeInsurance>(homeIns, this.headers);
		HomeInsurance homeInsNew = (HomeInsurance) rest.postForObject(this.urlBase+"saveHomeIns/", requestEntity2, HomeInsurance.class);
		
		HttpEntity<VehicleInsurance> requestEntity3 = new HttpEntity<VehicleInsurance>(carIns, this.headers);
		VehicleInsurance carInsNew = (VehicleInsurance) rest.postForObject(this.urlBase+"saveVehicleInsurance/", requestEntity3, VehicleInsurance.class);
		
		Set<Long> clientsIds = new HashSet<Long>();
		for(Client c : clients){
			HttpEntity<Client> requestEntity4 = new HttpEntity<Client>(c, this.headers);
			Client clientNew = (Client) rest.postForObject(this.urlBase+"saveClient/", requestEntity4, Client.class);
			clientsIds.add(clientNew.getId());
		}
		policyDal.setClients(clientsIds);
		policyDal.setHomeInsurance(homeInsNew);
		policyDal.setContractStart(travelInsDTO.getStartingDate());
		policyDal.setContractEnd(travelInsDTO.getEndingDate());
		policyDal.setInsuranceOwner(insuranceOwner.getId());
		policyDal.setPriceSummed(589);		// THIS
		policyDal.setTravelInsurance(travelInsNew);
		policyDal.setVehicleInsurance(carInsNew);
		// ITEMS: 
		Set<Long> riskItems = new HashSet<Long>();
		riskItems.add(Long.parseLong(travelInsDTO.getAges()));
		riskItems.add(Long.parseLong(travelInsDTO.getRegion()));
		riskItems.add(Long.parseLong(travelInsDTO.getSport()));
		riskItems.add(Long.parseLong(travelInsDTO.getAmmount()));
		if(homeInsDTO.getHomeAge()!="")
			riskItems.add(Long.parseLong(homeInsDTO.getHomeAge()));
		else
			System.out.println("EMPTY HOME AGE");
		if(homeInsDTO.getHomeSurface()!="")
		riskItems.add(Long.parseLong(homeInsDTO.getHomeSurface()));
		else
			System.out.println("EMPTY HOME SURFACE");
		if(homeInsDTO.getHomeValue()!="")
		riskItems.add(Long.parseLong(homeInsDTO.getHomeValue()));
		else
			System.out.println("EMPTY HOME VALUE");
		if(homeInsDTO.getInsuranceReason()!="")
		riskItems.add(Long.parseLong(homeInsDTO.getInsuranceReason()));
		else
			System.out.println("EMPTY HOME REASON");
		riskItems.add(Long.parseLong(carInsDTO.getRepairPrice()));
		riskItems.add(Long.parseLong(carInsDTO.getNumberOfHotelDays()));
		riskItems.add(Long.parseLong(carInsDTO.getAlternativeVehicle()));
		riskItems.add(Long.parseLong(carInsDTO.getNumberOfKm()));
		
		policyDal.setRiskItems(riskItems);
		HttpEntity<Policy> requestEntity5 = new HttpEntity<Policy>(policyDal, this.headers);
		Policy response = (Policy)rest.postForObject(this.urlBase+"savePolicy/", requestEntity5, Policy.class);
		System.out.println("Response is " + response.getPriceSummed());
		return ResponseEntity.ok(new String("OK"));
		
	}
	
	private void setRequestEntity(Object object){
		this.params = new HashMap<String, Object>();
		params.put("policy", object);
		this.requestEntity= new HttpEntity<Map<String, Object>>(params, this.headers);
	}
	
	private List<RiskItemDTO> getRiskByName(String name){
		this.params.put("name", name);
		 this.requestEntity = new HttpEntity<Map<String, Object>>(this.params, this.headers);
		 Risk responseEntity = (Risk)rest.postForObject(this.urlBase+"RiskName/", this.requestEntity, Risk.class);
		 
		 List<RiskItemDTO> retVal = new ArrayList<RiskItemDTO>();
		 for(RiskItem item : responseEntity.getRiskItems()){
			 retVal.add(new RiskItemDTO(item.getId(), item.getItemName()));
		 }
		 return retVal;
	}
}
