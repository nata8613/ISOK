package InsurancePOSService.demo.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import InsurancePOSService.demo.models.InsuranceCategory;
import InsurancePOSService.demo.models.PriceImpacts;
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
		urlBase = "http://localhost:8081/dc/isok/";
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
		return this.getRiskByName("Personal age");
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
		
		//  Na osnovu dobijenih podataka racuna cenu samo za putno osiguranje
		this.params.put("name", "TravelInsurance");
		 this.requestEntity = new HttpEntity<Map<String, String>>(this.params, this.headers);
 		InsuranceCategory category = (InsuranceCategory)rest.postForObject(this.urlBase+"categoryName/TravelInsurance", this.requestEntity,InsuranceCategory.class);
		double startingFee = category.getStartingPrice() + insurance.getNumberOfPeople()*category.getClientFee();
		double ageFee = this.getPriceImpactByRiskItemId(insurance.getAges());
		double regionFee = this.getPriceImpactByRiskItemId(insurance.getRegion());
		double sportFee = 0;
		if(insurance.getSport()!="")
			sportFee = this.getPriceImpactByRiskItemId(insurance.getSport());
		double ammountFee = this.getPriceImpactByRiskItemId(insurance.getAmmount());
		double sum = startingFee * (1 + ageFee + regionFee + sportFee + ammountFee);//"http://localhost:4300/Payment/5"
		/*HttpHeaders header = new HttpHeaders();
	      header.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	      URI loc = new URI("http://localhost:4300/Payment/5");
	      header.setLocation(loc);
	      List<String> list = new ArrayList<String>();
	      list.add("Access-Control-Allow-Origins");
	      header.setAccessControlAllowHeaders(list);
	     // resp.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Origins");
	      resp.setHeader("Access-Control-Allow-Origin", "*");
	      resp.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
	      resp.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Access-Control-Allow-Origin, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
	    //  resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
	      resp.sendRedirect("http://localhost:4300/Payment/5");
	      
	      return resp;*/
		return ResponseEntity.ok(sum);
		
	}
	
/*	@RequestMapping(value="/postPayment/{paymentId}", method=RequestMethod.POST)
	public ResponseEntity<DataAcqToPCC> postPayment(@PathVariable("paymentId") long paymentId, @RequestBody DataAcqToPCC data) {
		System.out.println("PAYID "+ paymentId);
		System.out.println("Data " + data.getAcquirerOrderId());
		System.out.println("1 " + data.getAmount());
		System.out.println("2 " + data.getCardHolderName());
		System.out.println("3 " + data.getPAN());
		System.out.println("4 " + data.getSecuityCode());
		System.out.println("5 " + data.getAcquirerTimestamp());
		System.out.println("6 " + data.getValidDate());
		return ResponseEntity.ok(data);
	}
*/	
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
