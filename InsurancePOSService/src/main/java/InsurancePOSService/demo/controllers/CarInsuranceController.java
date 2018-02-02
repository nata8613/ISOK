package InsurancePOSService.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import InsurancePOSService.demo.SifrarnikMetoda;
import InsurancePOSService.demo.annotations.PermissionType;
import InsurancePOSService.demo.models.CarInsuranceDTO;
import InsurancePOSService.demo.models.Client;
import InsurancePOSService.demo.models.HomeInsurance;
import InsurancePOSService.demo.models.HomeInsuranceDTO;
import InsurancePOSService.demo.models.InsuranceCategory;
import InsurancePOSService.demo.models.Person;
import InsurancePOSService.demo.models.Policy;
import InsurancePOSService.demo.models.PolicyDTO;
import InsurancePOSService.demo.models.PriceImpacts;
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
	private Map<String, String> params;
	private HttpEntity<Map<String, String>> requestEntity;
	final static Logger logger = LogManager.getLogger(CarInsuranceController.class);
	
	public CarInsuranceController(){
		urlBase = "http://localhost:8081/dc/isok/";
		rest = new RestTemplate();
		headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");
	    headers.add("Accept", "*/*");
		params = new HashMap<String, String>();
	}
	
	@RequestMapping("/getKilometers")
	@ResponseBody
	@PreAuthorize("hasAnyRole(['zaposlen', 'prodavac'])")
	public List<RiskItemDTO> getKilometers() {
		return this.getRiskByName("Transport km");
	}
	
	@RequestMapping("/getPrices")
	@ResponseBody
	@PreAuthorize("hasAnyRole(['zaposlen', 'prodavac'])")
	public List<RiskItemDTO> getPrices() {
		return this.getRiskByName("Repair Price");
	}
	
	@RequestMapping("/getHotelDays")
	@ResponseBody
	@PreAuthorize("hasAnyRole(['zaposlen', 'prodavac'])")
	public List<RiskItemDTO> getHotelDays() {
		return this.getRiskByName("Hotel Days");
	}
	
	@RequestMapping("/getAltVehicle")
	@ResponseBody
	@PreAuthorize("hasAnyRole(['zaposlen', 'prodavac'])")
	public List<RiskItemDTO> getAltVehicle() {
		return this.getRiskByName("Alt vehicle");
	}
	
	@RequestMapping(value="/createCarInsurance", method=RequestMethod.POST)
	@PreAuthorize("hasRole('prodavac')")
	@PermissionType("CarInsurance:create")
	public ResponseEntity<Double> carInsuranceValue(@RequestBody CarInsuranceDTO insurance) {
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
		//Na osnovu dobijenih podataka racuna cenu samo za osiguranje pomoc na putu
		this.params.put("name", "VehicleInsurance");
		 this.requestEntity = new HttpEntity<Map<String, String>>(this.params, this.headers);
		InsuranceCategory category = (InsuranceCategory)rest.postForObject(this.urlBase+"categoryName/VehicleInsurance", this.requestEntity,InsuranceCategory.class);
		double startingFee = category.getStartingPrice();
		double repairFee = 0;
		if(insurance.getRepairPrice()!="")
			repairFee = this.getPriceImpactByRiskItemId(insurance.getRepairPrice());
		double hotelFee =0;
		if(insurance.getNumberOfHotelDays()!="")
			hotelFee = this.getPriceImpactByRiskItemId(insurance.getNumberOfHotelDays());
		double altVehFee =0;
		if(insurance.getAlternativeVehicle()!="")
			altVehFee = this.getPriceImpactByRiskItemId(insurance.getAlternativeVehicle());
		double kmFee =0;
		if(insurance.getNumberOfKm()!="")
			kmFee = this.getPriceImpactByRiskItemId(insurance.getNumberOfKm());
		double sum = startingFee * (1 + repairFee + hotelFee + altVehFee + kmFee);
		return ResponseEntity.ok(sum);
	}
	
	private List<RiskItemDTO> getRiskByName(String name){
		this.params.put("name", name);
		 this.requestEntity = new HttpEntity<Map<String, String>>(this.params, this.headers);
		 Risk responseEntity = (Risk)rest.postForObject(this.urlBase+"RiskName/", this.requestEntity, Risk.class);
		 
		 List<RiskItemDTO> retVal = new ArrayList<RiskItemDTO>();
		 for(RiskItem item : responseEntity.getRiskItems()){
			 retVal.add(new RiskItemDTO(item.getId(), item.getItemName()));
		 }
		 return retVal;
	}
	private double getPriceImpactByRiskItemId(String riskId){
		Map<String, String> params2 = new HashMap<String, String>();
		params2.put("riskId", riskId);
		HttpEntity<Map<String, String>> requestEntity2 = new HttpEntity<Map<String, String>>(params2, this.headers);
		PriceImpacts impact = (PriceImpacts)rest.postForObject(this.urlBase+"ImpactRisk/", requestEntity2, PriceImpacts.class);
		return impact.getValue();
	}
	
}
