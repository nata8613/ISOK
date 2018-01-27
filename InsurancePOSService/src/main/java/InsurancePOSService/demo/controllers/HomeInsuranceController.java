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

import InsurancePOSService.demo.models.HomeInsuranceDTO;
import InsurancePOSService.demo.models.Risk;
import InsurancePOSService.demo.models.RiskItem;
import InsurancePOSService.demo.models.RiskItemDTO;

@Controller
@RequestMapping("/homeInsurance")
@CrossOrigin("*")
public class HomeInsuranceController {

	private String urlBase;
	private RestTemplate rest;
	private HttpHeaders headers;
	private Map<String, String> params;
	private HttpEntity<Map<String, String>> requestEntity;
	
	public HomeInsuranceController(){
		urlBase = "http://localhost:8080/dc/isok/";
		rest = new RestTemplate();
		headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");
	    headers.add("Accept", "*/*");
		params = new HashMap<String, String>();
	}
	
	
	@RequestMapping("/getHomeSurfaces")
	@ResponseBody
	public List<RiskItemDTO> getHomeSurfaces() {
		return this.getRiskByName("Home surface");
	}
	
	@RequestMapping("/getHomeAges")
	@ResponseBody
	public List<RiskItemDTO> getHomeAges(){
		return this.getRiskByName("Home Age");
	}
	
	@RequestMapping("/getHomeValues")
	@ResponseBody
	public List<RiskItemDTO> getHomeValues() {
		return this.getRiskByName("Home value");
	}
	
	// TO DO: GET DATA FROM DATABASE 
	@RequestMapping("/getInsuranceReasons")
	@ResponseBody
	public List<RiskItemDTO> getInsuranceReasons() {
		return this.getRiskByName("Insurance reason");
	}
	
	@RequestMapping(value="/createHomeInsurance", method=RequestMethod.POST)
	public ResponseEntity<Double> insuranceValue(@RequestBody HomeInsuranceDTO insurance) {
		
		// 	TO DO : Na osnovu dobijenih podataka izracunati cenu samo za osiguranje stana i vratiti
 		
		return ResponseEntity.ok(new Double(500));
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
