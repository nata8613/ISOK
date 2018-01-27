package InsurancePOSService.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import InsurancePOSService.demo.models.Risk;
import InsurancePOSService.demo.models.RiskItem;
import InsurancePOSService.demo.models.RiskItemDTO;
import InsurancePOSService.demo.models.TravelInsuranceDTO;

@Controller
@RequestMapping("/travelInsurance")
@CrossOrigin("*")
public class TravelInsuranceController {
	
	private String urlBase;
	private RestTemplate rest;
	private HttpHeaders headers;
	private Map<String, String> params;
	private HttpEntity<Map<String, String>> requestEntity;
	
	public TravelInsuranceController(){
		urlBase = "http://localhost:8080/dc/isok/";
		rest = new RestTemplate();
		headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");
	    headers.add("Accept", "*/*");
		params = new HashMap<String, String>();
	}
	
	@RequestMapping("/getRegions")
	@ResponseBody
	public List<RiskItemDTO> getRegions() {
		return this.getRiskByName("Destination");
	}
	
	@RequestMapping("/getAges")
	@ResponseBody
	public List<RiskItemDTO> getAge() {
		return this.getRiskByName("Age");
	}
	
	@RequestMapping("/getSports")
	@ResponseBody
	public List<RiskItemDTO> getSport() {
		return this.getRiskByName("Sport");
	}
	
	// do kog iznosa je osiguran korisnik
	@RequestMapping("/getInsuranceValues")
	@ResponseBody
	public List<RiskItemDTO> insuranceValue() {
		return this.getRiskByName("Insurance value");
	}
	
	//@PostMapping("/createTravelInsurance")
	@RequestMapping(value="/createTravelInsurance", method=RequestMethod.POST)
	public ResponseEntity<Double> insuranceValue(@RequestBody TravelInsuranceDTO insurance) {
		
		// 	TO DO : Na osnovu dobijenih podataka izracunati cenu samo za putno osiguranje i vratiti
 		
		
		return ResponseEntity.ok(new Double(300));
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
}
