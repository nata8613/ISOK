package com.PM.PMService.controllers;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.PM.PMService.SifrarnikMetoda;
import com.PM.PMService.TheUrls;
import com.PM.PMService.annotations.PermissionType;
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
	
	final static Logger logger = LogManager.getLogger(InventarContoller.class);
	/****************************** KATEGORIJA OSIGURANJA *************************/
	
	@RequestMapping("/addCategory")
	@ResponseBody
	@PreAuthorize("hasRole('finansijski analiticar')")
	@PermissionType("Category:create")
	public InsuranceCategory saveCategory(@RequestBody InsuranceCategory kategorija){
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/saveCategory";
		RestTemplate template = new RestTemplate();
		InsuranceCategory category = template.postForObject(url, kategorija, InsuranceCategory.class);
		System.out.println("DODATA JE KATEGORIJA "+ category.getCategoryName());
		
		return category;
		
	}
	
	@RequestMapping("/getCategories")
	@ResponseBody
	@PreAuthorize("hasAnyRole(['finansijski analiticar', 'prodavac'])")
	public InsuranceCategory[] getCategories(){
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/getCategories";
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<InsuranceCategory[]> responseEntity = template.getForEntity(url, InsuranceCategory[].class); 
		InsuranceCategory[] kategorije = responseEntity.getBody();
		System.out.println("BROJ KATEGORIJA JE "+ kategorije.length);
		
		return kategorije;
		
	}
	@RequestMapping("/updateCategory/{id}")
	@ResponseBody
	@PreAuthorize("hasRole('finansijski analiticar')")
	@PermissionType("Category:update")
	public InsuranceCategory updateCategory(@PathVariable("id") long id, @RequestBody InsuranceCategory kategorija){
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/updateCategory/{"+id+"}";
		RestTemplate template = new RestTemplate();
		
		InsuranceCategory category = template.postForObject(url, kategorija, InsuranceCategory.class);
		System.out.println("IZMENJENA JE KATEGORIJA "+ category.getCategoryName());
		
		return category;
		
	}
	
	@RequestMapping("/deleteCategory/{id}")
	@ResponseBody
	@PreAuthorize("hasRole('finansijski analiticar')")
	@PermissionType("Category:delete")
	public boolean deleteCategory(@PathVariable("id") long id){
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
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
	@PreAuthorize("hasAnyRole(['finansijski analiticar', 'prodavac'])")
	@PermissionType("RiskItem:create")
	public RiskItem saveRiskItem(@RequestBody HashMap<String, Object> risk){
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
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
	@PreAuthorize("hasAnyRole(['finansijski analiticar', 'prodavac'])")
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
	@PreAuthorize("hasAnyRole(['finansijski analiticar', 'prodavac'])")
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
	@PreAuthorize("hasRole('finansijski analiticar')")
	@PermissionType("RiskItem:update")
	public RiskItem updateRiskItem(@PathVariable("id") long id, @RequestBody RiskItem RiskItem){
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
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
	@PreAuthorize("hasRole('finansijski analiticar')")
	@PermissionType("RiskItem:delete")
	public boolean deleteRiskItem(@PathVariable("id") long id){
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
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
	@PreAuthorize("hasAnyRole(['finansijski analiticar', 'prodavac'])")
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
	@PreAuthorize("hasAnyRole(['finansijski analiticar', 'prodavac'])")
	@PermissionType("Risk:create")
	public Risk addRisK(@RequestBody HashMap<String,Object> risk){
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/saveRisk";
		RestTemplate template = new RestTemplate();
		
		Risk rizik = template.postForObject(url, risk, Risk.class);
		
		System.out.println("-------DODAT JE RIZIK------- "+ rizik.getRiskName());
		
		return rizik;
		
	}
	
	@RequestMapping("/updateRisk/{id}")
	@ResponseBody
	@PreAuthorize("hasAnyRole(['finansijski analiticar', 'prodavac'])")
	@PermissionType("Risk:update")
	public Risk updateRisk(@PathVariable("id") long id, @RequestBody Risk Risk){
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
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
	@PreAuthorize("hasRole('finansijski analiticar')")
	@PermissionType("Risk:delete")
	public boolean deleteRisk(@PathVariable("id") long id){
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
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
	@PreAuthorize("hasRole('finansijski analiticar')")

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
	@PreAuthorize("hasRole('finansijski analiticar')")
	@PermissionType("Rules:update")
	public Rules updateRules(@PathVariable("id") long id, @RequestBody Rules Rule){
		logger.warn("Executing method " + SifrarnikMetoda.methods.get(Thread.currentThread().getStackTrace()[1].getMethodName()));
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+"/dc/isok/updateRules/{"+id+"}";
		RestTemplate template = new RestTemplate();
	
		Rules rule = template.postForObject(url, Rule, Rules.class);
		System.out.println("------IZMENJEN JE RULE------ "+ rule.getRule());
		
		return rule;
		
	}
}
