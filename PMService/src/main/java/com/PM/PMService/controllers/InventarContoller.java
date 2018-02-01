package com.PM.PMService.controllers;

import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.PM.PMService.TheUrls;
import com.PM.PMService.models.InsuranceCategory;
import com.PM.PMService.models.Risk;
import com.PM.PMService.models.RiskItem;
import com.PM.PMService.models.Rules;

@Controller
public class InventarContoller {
 /*
	@RequestMapping(value="/getClients", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> getAllClients(){
		List<Client> clients = new ArrayList<Client>();
		clients = (List<Client>) clientRepo.findAll();
		return clients;
	}*/
	/****************************** KATEGORIJA OSIGURANJA *************************/
	
	@RequestMapping("/addCategory")
	@ResponseBody
	public InsuranceCategory saveCategory(@RequestBody InsuranceCategory kategorija){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/saveCategory";
		RestTemplate template = new RestTemplate();
		InsuranceCategory category = template.postForObject(url, kategorija, InsuranceCategory.class);
		System.out.println("DODATA JE KATEGORIJA "+ category.getCategoryName());
		
		return category;
		
	}
	
	@RequestMapping("/getCategories")
	@ResponseBody
	public InsuranceCategory[] getCategories(){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/getCategories";
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<InsuranceCategory[]> responseEntity = template.getForEntity(url, InsuranceCategory[].class); 
		InsuranceCategory[] kategorije = responseEntity.getBody();
		System.out.println("BROJ KATEGORIJA JE "+ kategorije.length);
		
		return kategorije;
		
	}
	@RequestMapping("/updateCategory/{id}")
	@ResponseBody
	public InsuranceCategory updateCategory(@PathVariable("id") long id, @RequestBody InsuranceCategory kategorija){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/updateCategory/{"+id+"}";
		RestTemplate template = new RestTemplate();
		
		InsuranceCategory category = template.postForObject(url, kategorija, InsuranceCategory.class);
		System.out.println("IZMENJENA JE KATEGORIJA "+ category.getCategoryName());
		
		return category;
		
	}
	
	@RequestMapping("/deleteCategory/{id}")
	@ResponseBody
	public boolean deleteCategory(@PathVariable("id") long id){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/deleteCategory/"+id;
		RestTemplate template = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		boolean deleted = template.postForObject(url, request, Boolean.class);
		return deleted;
		
	}
	
	/****************************** RISK ITEM-I ************************************/
	
	@RequestMapping("/RiskItemByRisk")
	@ResponseBody
	public RiskItem[] RiskItemByRisk(@RequestBody Risk risk){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/RiskItemByRisk";
		RestTemplate template = new RestTemplate();

		RiskItem[] itemi = template.postForObject(url, risk, RiskItem[].class);
		System.out.println("BROJ KATEGORIJA JE "+ itemi.length);
		
		return itemi;
		
	}
	
	@RequestMapping("/saveRiskItem")
	@ResponseBody
	public RiskItem saveRiskItem(@RequestBody HashMap<String, Object> risk){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/saveRiskItem";
		RestTemplate template = new RestTemplate();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("risk", risk.get("risk"));
		map.put("item", risk.get("item"));
		RiskItem riskItem = template.postForObject(url, map, RiskItem.class);
		System.out.println("------SACUVAN JE RISKITEM------"+ riskItem);
		
		return riskItem;
		
	}
	
	@RequestMapping("/getRiskItems")
	@ResponseBody
	public RiskItem[] getRiskItems(){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/getRiskItems";
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<RiskItem[]> responseEntity = template.getForEntity(url, RiskItem[].class); 
		RiskItem[] riskItems = responseEntity.getBody();
		System.out.println("BROJ KATEGORIJA JE "+ riskItems.length);
		
		return riskItems;
		
	}
	
	@RequestMapping("/getRiskItem")
	@ResponseBody
	public RiskItem getRiskItem(@PathVariable("id") long id){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/getRiskItem";
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("id", Long.toString(id));
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		RiskItem riskItem = template.postForObject(url, request, RiskItem.class); 
		System.out.println("-------RiskItem je:---- "+ riskItem);
		
		return riskItem;
		
	}
	
	@RequestMapping("/updateRiskItem/{id}")
	@ResponseBody
	public RiskItem updateRiskItem(@PathVariable("id") long id, @RequestBody RiskItem RiskItem){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/updateRiskItem/{"+id+"}";
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
		map.add("item", RiskItem);
		map.add("risk", RiskItem.getRisk());
		map.add("policies", RiskItem.getPolicies());
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
		RiskItem riskItem = template.postForObject(url, request, RiskItem.class);
		System.out.println("------IZMENJEN JE RISKITEM------ "+ riskItem.getItemName());
		
		return riskItem;
		
	}
	
	@RequestMapping("/deleteRiskItem/{id}")
	@ResponseBody
	public boolean deleteRiskItem(@PathVariable("id") long id){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/deleteRiskItem/"+id;
		RestTemplate template = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		boolean deleted = template.postForObject(url, request, Boolean.class);
		return deleted;
		
	}
	
	
	/********************************** RIZICI ************************************/
	@RequestMapping("/getRisks")
	@ResponseBody
	public Risk[] getRisks(){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/getRisks";
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<Risk[]> responseEntity = template.getForEntity(url, Risk[].class); 
		Risk[] risks = responseEntity.getBody();
		System.out.println("BROJ RIZIKA JE "+ risks.length);
		
		return risks;
		
	}
	/**
	 * @param mapa koja ima objekat rizika (key="risk") i listu objekata kategorije (key="categories")
	 * */
	@RequestMapping("/addRisk")
	@ResponseBody
	public Risk addRisK(@RequestBody HashMap<String,Object> risk){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/saveRisk";
		RestTemplate template = new RestTemplate();
		
		Risk rizik = template.postForObject(url, risk, Risk.class);
		
		System.out.println("-------DODAT JE RIZIK------- "+ rizik.getRiskName());
		
		return rizik;
		
	}
	
	@RequestMapping("/updateRisk/{id}")
	@ResponseBody
	public Risk updateRisk(@PathVariable("id") long id, @RequestBody Risk Risk){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/updateRisk/{"+id+"}";
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
		map.add("risk", Risk);
		map.add("categories", Risk.getCategories());
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
		Risk risk = template.postForObject(url, request, Risk.class);
		System.out.println("------IZMENJEN JE RISK------ "+ risk.getRiskName());
		
		return risk;
		
	}
	
	@RequestMapping("/deleteRisk/{id}")
	@ResponseBody
	public boolean deleteRisk(@PathVariable("id") long id){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/deleteRisk/"+id;
		RestTemplate template = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		boolean deleted = template.postForObject(url, request, Boolean.class);
		return deleted;
		
	}
	
	/****************************** RULES ************************************/
	
	@RequestMapping("/getRules")
	@ResponseBody
	public Rules[] getRules(){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/getRules";
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<Rules[]> responseEntity = template.getForEntity(url, Rules[].class); 
		Rules[] rules = responseEntity.getBody();
		System.out.println("------got rule-------");
		
		return rules;
		
	}
	
	@RequestMapping("/updateRules/{id}")
	@ResponseBody
	public Rules updateRules(@PathVariable("id") long id, @RequestBody Rules Rule){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/updateRules/{"+id+"}";
		RestTemplate template = new RestTemplate();
	
		Rules rule = template.postForObject(url, Rule, Rules.class);
		System.out.println("------IZMENJEN JE RULE------ "+ rule.getRule());
		
		return rule;
		
	}
}
