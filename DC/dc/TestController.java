package com.example.demo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//BITNI IMPORTI ZA REST TEMPLATE
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Bank;
import com.example.demo.model.InsuranceCategory;
import com.example.demo.model.Risk;
import com.example.demo.repo.InsuranceCategoryRepo;
import com.example.demo.repo.RiskRepo;


//Nemojte zaboraviti da vasa aplikacija/projekat mora imati klase koje zelite da dobijete od DC

@Controller
public class TestController {

//prva verzija
	@RequestMapping("/getBanks")
	@ResponseBody
	public Bank[] getBanks(){
		
		final String url = "http://localhost:8080/dc/pcc/testPcc";
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<Bank[]> responseEntity = template.getForEntity(url, Bank[].class); 
		Bank[] banke = responseEntity.getBody();
		//System.out.println(banke[0].getMerchants().iterator().next().getBank().getBankID());
		return banke;
	}
	
	//theUrls je staticka klasa (dodala sam vam .java fajl za nju) - cisto da lakse mozete menjati delove urlova koje gadjate
	
	@RequestMapping("/getBanks/{name}")
	@ResponseBody
	public Bank[] getBanks(@PathVariable("name") String name){
		
		//final String url = "http://localhost:8080/dc/pcc/getBanks/";
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+TheUrls.dcPcc+"/getBanks/"+name;
		RestTemplate template = new RestTemplate();
	//testirala nesto, ne utice na response
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("name", name);
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		//ovako hoce da vrati, kada sam trazila listu, nije moglo da konvertuje
		Bank[] banke = template.postForObject(url, request, Bank[].class); 
		//Bank[] banke = responseEntity.getBody();
		return banke;
	}
	
	@RequestMapping("/getBanksSwift/{swift}")
	@ResponseBody
	public Bank getSwift(@PathVariable("swift") String swift){
		
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+TheUrls.dcPcc+"/getBankSwift/"+swift;
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		Bank banka = template.postForObject(url, request, Bank.class); 
		return banka;
	}
	
	@RequestMapping("/testAdding/")
	@ResponseBody
	public Bank addTestBank(){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+TheUrls.dcPcc+"/saveBank/";
		RestTemplate template = new RestTemplate();
		Bank bank = new Bank();
		bank.setBillingAccount("58791618561648");
		bank.setCode(658);
		bank.setName("test");
		bank.setSwiftCode("78912345");
		Bank banka = template.postForObject(url, bank, Bank.class);
		return banka;
	}
	
	@RequestMapping("/updateBank/")
	@ResponseBody
	public Bank updateBank(){
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+TheUrls.dcPcc+"/updateBank/"+5;
		RestTemplate template = new RestTemplate();
		Bank bank = new Bank();
		bank.setBillingAccount("58791618561648");
		bank.setCode(658);
		bank.setName("nije test");
		bank.setSwiftCode("78912345");
		Bank banka = template.postForObject(url, bank, Bank.class);
		return banka;
	}
	
	@RequestMapping("/deleteBank/{id}")
	@ResponseBody
	public boolean deleteBanka(@PathVariable("id") long id){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+TheUrls.dcPcc+"/deleteBank/"+id;
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		boolean deleted = template.postForObject(url, request, Boolean.class);
		return deleted;
	}
	
	
	@RequestMapping("/testAddRisk/")
	@ResponseBody
	public Risk addTestRisk(){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+TheUrls.dcIsok+"/saveRisk/";
		final String url2 = "http://"+TheUrls.ip+":"+TheUrls.port+TheUrls.dcIsok+"/getCategories/";
		System.out.println("proslo");
		RestTemplate template = new RestTemplate();
		Risk risk = new Risk();
		risk.setRiskName("test1");
		List<InsuranceCategory> cats = new ArrayList<InsuranceCategory>();
		ResponseEntity<InsuranceCategory[]> responseEntity = template.getForEntity(url2, InsuranceCategory[].class);
		System.out.println("dobili kategorije");
		InsuranceCategory[] response = responseEntity.getBody();
		cats.add(response[0]);
		cats.add(response[1]);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("risk", risk);
		map.put("categories", cats);
		Risk rizik = template.postForObject(url, map, Risk.class);
		return rizik;
	}
	
	@RequestMapping("/testUpdateRisk/{id}")
	@ResponseBody
	public Risk updateTestRisk(@PathVariable("id") String id){
		
		final String url = "http://"+TheUrls.ip+":"+TheUrls.port+TheUrls.dcIsok+"/updateRisk/"+id;
		final String url2 = "http://"+TheUrls.ip+":"+TheUrls.port+TheUrls.dcIsok+"/getCategories/";
		final String url3 = "http://"+TheUrls.ip+":"+TheUrls.port+TheUrls.dcIsok+"/getRisks/";
		RestTemplate template = new RestTemplate();
		ResponseEntity<Risk[]> responseEntity = template.getForEntity(url3, Risk[].class);
		Risk[] response = responseEntity.getBody();
		Risk risk = response[9];
		risk.setRiskName("testtttt1");
		List<InsuranceCategory> cats = new ArrayList<InsuranceCategory>();
		ResponseEntity<InsuranceCategory[]> responseEntity2 = template.getForEntity(url2, InsuranceCategory[].class);
		InsuranceCategory[] response2 = responseEntity2.getBody();
		cats.add(response2[0]);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("risk", risk);
		map.put("categories", cats);
		Risk rizik = template.postForObject(url, map, Risk.class);
		return rizik;
	}
	
	/*
	@Autowired
	private InsuranceCategoryRepo insCatRepo;
	
	@Autowired
	private RiskRepo riskRepo;*/
}
