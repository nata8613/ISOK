package InsurancePOSService.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import InsurancePOSService.demo.models.HomeInsuranceDTO;
import InsurancePOSService.demo.models.InsuranceCategory;
import InsurancePOSService.demo.models.PriceImpacts;
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
	final static Logger logger = LogManager.getLogger(HomeInsuranceController.class);
	
	public HomeInsuranceController(){
		urlBase = "http://localhost:8081/dc/isok/";
		rest = new RestTemplate();
		headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");
	    headers.add("Accept", "*/*");
		params = new HashMap<String, String>();
	}
	
	
	@RequestMapping("/getHomeSurfaces")
	@ResponseBody
	@PreAuthorize("hasAnyRole(['zaposlen', 'prodavac'])")
	public List<RiskItemDTO> getHomeSurfaces() {
		return this.getRiskByName("Home surface");
	}
	
	@RequestMapping("/getHomeAges")
	@ResponseBody
	@PreAuthorize("hasAnyRole(['zaposlen', 'prodavac'])")
	public List<RiskItemDTO> getHomeAges(){
		return this.getRiskByName("Home Age");
	}
	
	@RequestMapping("/getHomeValues")
	@ResponseBody
	@PreAuthorize("hasAnyRole(['zaposlen', 'prodavac'])")
	public List<RiskItemDTO> getHomeValues() {
		return this.getRiskByName("Home value");
	}
	
	@RequestMapping("/getInsuranceReasons")
	@ResponseBody
	@PreAuthorize("hasAnyRole(['zaposlen', 'prodavac'])")
	public List<RiskItemDTO> getInsuranceReasons() {
		return this.getRiskByName("Insurance reason");
	}
	
	@RequestMapping(value="/createHomeInsurance", method=RequestMethod.POST)
	@PreAuthorize("hasAnyRole(['zaposlen', 'prodavac'])")
	@PermissionType("HomeInsurance:create")
	public ResponseEntity<Double> homeInsuranceValue(@RequestBody HomeInsuranceDTO insurance) {
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
		//Na osnovu dobijenih podataka racuna cenu samo za osiguranje stana
		this.params.put("name", "HomeInsurance");
		 this.requestEntity = new HttpEntity<Map<String, String>>(this.params, this.headers);
		InsuranceCategory category = (InsuranceCategory)rest.postForObject(this.urlBase+"categoryName/HomeInsurance", this.requestEntity,InsuranceCategory.class);
		double startingFee = category.getStartingPrice();
		double ageFee = this.getPriceImpactByRiskItemId(insurance.getHomeAge());
		double surfaceFee =this.getPriceImpactByRiskItemId(insurance.getHomeSurface());
		double valueFee = this.getPriceImpactByRiskItemId(insurance.getHomeValue());
		double reasonFee = this.getPriceImpactByRiskItemId(insurance.getInsuranceReason());
		double sum = startingFee * (1 + ageFee + surfaceFee + valueFee + reasonFee);
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
