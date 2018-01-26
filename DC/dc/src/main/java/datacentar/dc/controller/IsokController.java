package datacentar.dc.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import datacentar.dc.isok.model.Client;
import datacentar.dc.isok.model.HomeInsurance;
import datacentar.dc.isok.model.InsuranceCategory;
import datacentar.dc.isok.model.Policy;
import datacentar.dc.isok.model.PriceImpacts;
import datacentar.dc.isok.model.Pricelist;
import datacentar.dc.isok.model.Risk;
import datacentar.dc.isok.model.RiskItem;
import datacentar.dc.isok.model.Rules;
import datacentar.dc.isok.model.TravelInsurance;
import datacentar.dc.isok.model.VehicleInsurance;
import datacentar.dc.isok.repo.ClientRepo;
import datacentar.dc.isok.repo.HomeInsuranceRepo;
import datacentar.dc.isok.repo.InsuranceCategoryRepo;
import datacentar.dc.isok.repo.PolicyRepo;
import datacentar.dc.isok.repo.PriceImpactsRepo;
import datacentar.dc.isok.repo.PricelistRepo;
import datacentar.dc.isok.repo.RiskItemRepo;
import datacentar.dc.isok.repo.RiskRepo;
import datacentar.dc.isok.repo.RulesRepo;
import datacentar.dc.isok.repo.TravelInsuranceRepo;
import datacentar.dc.isok.repo.VehicleInsuranceRepo;

@Controller
@RequestMapping("/dc/isok")
public class IsokController {
	
	/////////////////TODO: CLIENT METODE/////////////
	@Transactional("isokTransactionManager")
	@RequestMapping(value="/getClients", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> getAllClients(){
		List<Client> clients = new ArrayList<Client>();
		clients = (List<Client>) clientRepo.findAll();
		return clients;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/saveClient/", method = RequestMethod.POST)
	@ResponseBody
	public Client saveClient(@RequestBody Client client) {
		Client client1 = clientRepo.findOne(client.getId());
		if (client1 != null)
			return null;
		client1 = clientRepo.save(client);
		return client1;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/updateClient/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Client updateClient(@PathVariable("id") long id, @RequestBody Client client) {
		
		Client client1 = clientRepo.findOne(client.getId());		
		if(client1 == null)
			return null;
		client1.setAddress(client.getAddress());
		client1.setClientEmail(client.getClientEmail());
		client1.setClientName(client.getClientName());
		client1.setClientSurname(client.getClientSurname());
		client1.setJmbg(client.getJmbg());
		client1.setPassportNum(client.getPassportNum());
		client1.setTelNum(client.getTelNum());
		client1 = clientRepo.save(client1);
		return client1;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/deleteClient/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteClient(@PathVariable("id") long id) {
		Client client = clientRepo.findOne(id);
		if(client == null)
			return false;
		try {
			for(Policy p : client.getPolicies()){
				Policy temp = policyRepo.findOne(p.getId());
				temp.getClients().remove(client);
				policyRepo.save(temp);
			}
			clientRepo.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/clientJMBG/{jmbg}", method = RequestMethod.POST)
	@ResponseBody
	public Client findClientJMBG(@PathVariable("jmbg") String jmbg) {
		Client client1 = clientRepo.findByJmbg(jmbg);		
		return client1;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/clientPassport/{number}", method = RequestMethod.POST)
	@ResponseBody
	public Client findClientPassport(@PathVariable("number") String number) {
		Client client1 = clientRepo.findByPassportNum(number);		
		return client1;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/clientEmail/{email}", method = RequestMethod.POST)
	@ResponseBody
	public List<Client> findClientEmail(@PathVariable("email") String email) {
		List<Client> client1 = clientRepo.findByClientEmail(email);		
		return client1;
	}
	
	
	/////////////////TODO: CATEGORY METODE//////////////////
	@Transactional("isokTransactionManager")
	@RequestMapping(value="/getCategories", method = RequestMethod.GET)
	@ResponseBody
	public List<InsuranceCategory> getCategories(){
		List<InsuranceCategory> categories = new ArrayList<InsuranceCategory>();
		categories = (List<InsuranceCategory>) insCatRepo.findAll();
		return categories;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/saveCategory/", method = RequestMethod.POST)
	@ResponseBody
	public InsuranceCategory saveCategory(@RequestBody InsuranceCategory cat) {
		InsuranceCategory cat1 = insCatRepo.findOne(cat.getId());
		if (cat1 != null)
			return null;
		cat1 = insCatRepo.save(cat);
		return cat1;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/updateCategory/{id}", method = RequestMethod.POST)
	@ResponseBody
	public InsuranceCategory updateCategory(@PathVariable("id") long id, @RequestBody InsuranceCategory category) {
		
		InsuranceCategory cat = insCatRepo.findOne(category.getId());		
		if(cat == null)
			return null;
		cat.setCategoryName(category.getCategoryName());
		cat.getRisks().clear();
		for(Risk r : category.getRisks()){
			Risk temp = riskRepo.findOne(r.getId());
			cat.getRisks().add(temp);
		}
		cat = insCatRepo.save(cat);
		return cat;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteCategory(@PathVariable("id") long id) {
		InsuranceCategory cat = insCatRepo.findOne(id);
		if(cat == null)
			return false;
		try {
			insCatRepo.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/categoryName/{name}", method = RequestMethod.POST)
	@ResponseBody
	public InsuranceCategory findCategoryName(@PathVariable("name") String name) {
		InsuranceCategory client1 = insCatRepo.findByCategoryName(name);		
		return client1;
	}
	
	
	/////////////////////TODO: HOME INSURANCE METODE////////////////////
	@Transactional("isokTransactionManager")
	@RequestMapping(value="/getHomeIns", method = RequestMethod.GET)
	@ResponseBody
	public List<HomeInsurance> getHomeInsurance(){
		List<HomeInsurance> insurances = (List<HomeInsurance>) homeInsRepo.findAll();
		return insurances;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/saveHomeIns/", method = RequestMethod.POST)
	@ResponseBody
	public HomeInsurance saveHomeInsurance(@RequestBody HomeInsurance insurance) {
		HomeInsurance cat1 = homeInsRepo.findOne(insurance.getId());
		if (cat1 != null)
			return null;
		cat1 = homeInsRepo.save(insurance);
		return cat1;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/updateHomeIns/{id}", method = RequestMethod.POST)
	@ResponseBody
	public HomeInsurance updateHomeInsurance(@PathVariable("id") long id, @RequestBody HomeInsurance insurance) {
		
		HomeInsurance cat = homeInsRepo.findOne(insurance.getId());		
		if(cat == null)
			return null;
		cat.setOwnerName(insurance.getOwnerName());
		cat.setOwnerSurname(insurance.getOwnerSurname());
		cat.setJmbg(insurance.getJmbg());
		cat.setInsuranceLength(insurance.getInsuranceLength());
		cat = homeInsRepo.save(cat);
		return cat;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/deleteHomeIns/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteHomeInsurance(@PathVariable("id") long id) {
		HomeInsurance cat = homeInsRepo.findOne(id);
		if(cat == null)
			return false;
		try {
			homeInsRepo.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/homeInsOwner/{owner}", method = RequestMethod.POST)
	@ResponseBody
	public List<HomeInsurance> findHomeOwner(@PathVariable("owner") String owner) {
		String[] ownerDetails = owner.split(" ");
		List<HomeInsurance> insurances = homeInsRepo.findByOwnerNameContainingOrOwnerSurnameContaining(ownerDetails[0],
				ownerDetails[1]);		
		return insurances;
	}
	
	
	///////////TODO: POLICY METODE///////////////////
	@Transactional("isokTransactionManager")
	@RequestMapping(value="/getPolicies", method = RequestMethod.GET)
	@ResponseBody
	public List<Policy> getPolicies(){
		List<Policy> policies = (List<Policy>) policyRepo.findAll();
		return policies;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/savePolicy/", method = RequestMethod.POST)
	@ResponseBody
	public Policy savePolicy(@RequestBody Policy policy) {
		Policy pol = policyRepo.findOne(policy.getId());
		if (pol != null)
			return null;
		pol = policyRepo.save(policy);
		return pol;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/updatePolicy/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Policy updatePolicy(@PathVariable("id") long id, @RequestBody Policy policy) {
		Policy cat = policyRepo.findOne(policy.getId());		
		if(cat == null)
			return null;
		cat.setContractEnd(policy.getContractEnd());
		cat.setContractStart(policy.getContractStart());
		if(policy.getHomeInsurance() != null){
			HomeInsurance home = homeInsRepo.findOne(policy.getHomeInsurance().getId());
			cat.setHomeInsurance(home);
		}
		if(policy.getInsuranceOwner() != null){
			Client owner = clientRepo.findOne(policy.getInsuranceOwner().getId());
			cat.setInsuranceOwner(owner);
		}
		cat.setPriceSummed(policy.getPriceSummed());
		if(policy.getTravelInsurance() != null){
			TravelInsurance travel = travelInsRepo.findOne(policy.getTravelInsurance().getId());
			cat.setTravelInsurance(travel);
		}
		if(!policy.getClients().isEmpty()){
			cat.getClients().clear();
			for(Client c : policy.getClients()){
				Client temp = clientRepo.findOne(c.getId());
				cat.getClients().add(temp);
			}
		}
		if(!policy.getRiskItems().isEmpty()){
			cat.getRiskItems().clear();
			for(RiskItem item : policy.getRiskItems()){
				RiskItem t = riskItemRepo.findOne(item.getId());
				cat.getRiskItems().add(t);
			}
		}
		cat = policyRepo.save(cat);
		return cat;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/deletePolicy/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deletePolicy(@PathVariable("id") long id) {
		Policy cat = policyRepo.findOne(id);
		if(cat == null)
			return false;
		try {
			policyRepo.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/PolicyOwner/", method = RequestMethod.POST)
	@ResponseBody
	public List<Policy> getPolicyOwner(@RequestBody Client client) {
		Client owner = clientRepo.findOne(client.getId());
		List<Policy> cat = policyRepo.findByInsuranceOwner(owner);
		return cat;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/PolicyStart/", method = RequestMethod.POST)
	@ResponseBody
	public List<Policy> getPolicyStart(@RequestBody Date startDate) {
		List<Policy> cat = policyRepo.findByContractStart(startDate);
		return cat;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/PolicyEnd/", method = RequestMethod.POST)
	@ResponseBody
	public List<Policy> getPolicyEnd(@RequestBody Date endDate) {
		List<Policy> cat = policyRepo.findByContractEndLessThan(endDate);
		return cat;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/PolicyTravel/", method = RequestMethod.POST)
	@ResponseBody
	public Policy getPolicyTravel(@RequestBody TravelInsurance insurance) {
		Policy cat = policyRepo.findByTravelInsurance(insurance);
		return cat;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/PolicyHome/", method = RequestMethod.POST)
	@ResponseBody
	public Policy getPolicyHome(@RequestBody HomeInsurance insurance) {
		Policy cat = policyRepo.findByHomeInsurance(insurance);
		return cat;
	}
	
	
	//////////////////TODO: PriceImpact METODE//////////////
	@Transactional("isokTransactionManager")
	@RequestMapping(value="/getImpacts", method = RequestMethod.GET)
	@ResponseBody
	public List<PriceImpacts> getImpacts(){
		List<PriceImpacts> policies = (List<PriceImpacts>) priceImpRepo.findAll();
		return policies;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/saveImpact/", method = RequestMethod.POST)
	@ResponseBody
	public PriceImpacts saveImpact(@RequestBody HashMap<String, Object> impact) {
		ObjectMapper mapper = new ObjectMapper();
		PriceImpacts pol = mapper.convertValue(impact.get("impact"), PriceImpacts.class);
		RiskItem item = mapper.convertValue(impact.get("item"),  new TypeReference<RiskItem>() {});
		PriceImpacts postoji = priceImpRepo.findOne(pol.getId());
		if (postoji != null)
			return null;
		if(item != null){
			item = riskItemRepo.findOne(item.getId());
			pol.setItem(item);
		}
		pol = priceImpRepo.save(pol);
		return pol;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/updateImpact/{id}", method = RequestMethod.POST)
	@ResponseBody
	public PriceImpacts updateImpact(@PathVariable("id") long id, @RequestBody HashMap<String, Object> impact) {
		ObjectMapper mapper = new ObjectMapper();
		PriceImpacts pol = mapper.convertValue(impact.get("impact"), PriceImpacts.class);
		RiskItem item = mapper.convertValue(impact.get("item"),  new TypeReference<RiskItem>() {});
		List<Pricelist> pricelists = mapper.convertValue(impact.get("pricelists"),  new TypeReference<List<Pricelist>>() {}); 
		PriceImpacts postoji = priceImpRepo.findOne(pol.getId());
		if (postoji == null)
			return null;
		item = riskItemRepo.findOne(item.getId());
		postoji.setItem(item);
		postoji.setValue(pol.getValue());
		postoji.getPricelists().clear();
		if(!pricelists.isEmpty()){
			for(Pricelist p : pricelists){
				Pricelist temp = pricelistRepo.findOne(p.getId());
				if(!temp.getImpacts().contains(postoji)){
					temp.getImpacts().add(postoji);
					pricelistRepo.save(temp);
					postoji.getPricelists().add(temp); //mozda nije bitno
				}
			}
		}
		postoji = priceImpRepo.save(postoji);
		return postoji;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/deleteImpact/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deletePriceImpact(@PathVariable("id") long id) {
		PriceImpacts cat = priceImpRepo.findOne(id);
		if(cat == null)
			return false;
		try {
			for(Pricelist p : cat.getPricelists()){
				Pricelist temp = pricelistRepo.findOne(p.getId());
				temp.getImpacts().remove(cat);
				pricelistRepo.save(temp);
			}
			priceImpRepo.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/ImpactRisk/", method = RequestMethod.POST)
	@ResponseBody
	public List<PriceImpacts> getImpactByRisk(@RequestBody RiskItem risk) {
		RiskItem item = riskItemRepo.findOne(risk.getId());
		List<PriceImpacts> cat = priceImpRepo.findByItem(item);
		return cat;
	}
	/*
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/ImpactDateFrom/", method = RequestMethod.POST)
	@ResponseBody
	public List<PriceImpacts> getImpactDateFrom(@RequestBody Date dateFrom) {
		List<PriceImpacts> cat = priceImpRepo.findByValidFrom(dateFrom);
		return cat;
	}
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/ImpactDateTo/", method = RequestMethod.POST)
	@ResponseBody
	public List<PriceImpacts> getImpactDateTo(@RequestBody Date dateTo) {
		List<PriceImpacts> cat = priceImpRepo.findByValidTo(dateTo);
		return cat;
	}*/
	
	
	////////////////TODO: PRICELIST METODE/////////////////
	@Transactional("isokTransactionManager")
	@RequestMapping(value="/getPricelists", method = RequestMethod.GET)
	@ResponseBody
	public List<Pricelist> getPricelists(){
		List<Pricelist> lists = (List<Pricelist>) pricelistRepo.findAll();
		return lists;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/savePricelist/", method = RequestMethod.POST)
	@ResponseBody
	public Pricelist savePricelist(@RequestBody Pricelist list) {
		Pricelist plist = pricelistRepo.findOne(list.getId());
		if (plist != null)
			return null;
		Pricelist temp = new Pricelist();
		temp.setValidFrom(list.getValidFrom());
		temp.setValidTo(list.getValidTo());
		if(!list.getImpacts().isEmpty()){
			for(PriceImpacts p : list.getImpacts()){
				PriceImpacts impact = priceImpRepo.findOne(p.getId());
				temp.getImpacts().add(impact);
			}
		}
		temp = pricelistRepo.save(temp);
		return temp;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/updatePricelist/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Pricelist updatePricelist(@PathVariable("id") long id, @RequestBody Pricelist list) {
		Pricelist cat = pricelistRepo.findOne(list.getId());		
		if(cat == null)
			return null;
		cat.setValidFrom(list.getValidFrom());
		cat.setValidTo(list.getValidTo());
		if(!list.getImpacts().isEmpty()){
			cat.getImpacts().clear();
			for(PriceImpacts p : list.getImpacts()){
				PriceImpacts impact = priceImpRepo.findOne(p.getId());
				cat.getImpacts().add(impact);
			}
		}
		cat = pricelistRepo.save(cat);
		return cat;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/deletePricelist/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deletePricelist(@PathVariable("id") long id) {
		Pricelist cat = pricelistRepo.findOne(id);
		if(cat == null)
			return false;
		try {
			pricelistRepo.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/PricelistDateFrom/", method = RequestMethod.POST)
	@ResponseBody
	public Pricelist getPricelistDateFrom(@RequestBody Date dateFrom) {
		List<Pricelist> cat = pricelistRepo.findByValidFromGreaterThanAndValidToLessThanOrderByValidFromDesc(dateFrom, dateFrom);
		return cat.get(0);
	}
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/PricelistDateTo/", method = RequestMethod.POST)
	@ResponseBody
	public List<Pricelist> getPricelistDateTo(@RequestBody Date dateTo) {
		List<Pricelist> cat = pricelistRepo.findByValidTo(dateTo);
		return cat;
	}
	
	
	////////////TODO: RISKITEM METODE/////////////////////
	@Transactional("isokTransactionManager")
	@RequestMapping(value="/getRiskItems", method = RequestMethod.GET)
	@ResponseBody
	public List<RiskItem> getRiskItems(){
		List<RiskItem> items = (List<RiskItem>) riskItemRepo.findAll();
		return items;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value="/getRiskItem/", method = RequestMethod.GET)
	@ResponseBody
	public RiskItem getRiskItem(@RequestBody String id){
		Long id2 = Long.parseLong(id);
		RiskItem item = riskItemRepo.findOne(id2);
		return item;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/saveRiskItem/", method = RequestMethod.POST)
	@ResponseBody
	public RiskItem saveItem(@RequestBody HashMap<String, Object> risk) {
		ObjectMapper mapper = new ObjectMapper();
		RiskItem pol = mapper.convertValue(risk.get("item"), RiskItem.class);
		Risk parentRisk = mapper.convertValue(risk.get("risk"),  new TypeReference<Risk>() {}); 
		RiskItem item = riskItemRepo.findOne(pol.getId());
		if (item != null)
			return null;
		if(parentRisk != null){
			parentRisk = riskRepo.findOne(parentRisk.getId());
			pol.setRisk(parentRisk);
		}
		pol = riskItemRepo.save(pol);
		return pol;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/updateRiskItem/{id}", method = RequestMethod.POST)
	@ResponseBody
	public RiskItem updateRiskItem(@PathVariable("id") long id, @RequestBody HashMap<String,Object> item) {
		ObjectMapper mapper = new ObjectMapper();
		RiskItem pol = mapper.convertValue(item.get("item"), RiskItem.class);
		Risk risk = mapper.convertValue(item.get("risk"), Risk.class);
		List<Policy> policies = mapper.convertValue(item.get("policies"),  new TypeReference<List<Policy>>() {});
		RiskItem cat = riskItemRepo.findOne(pol.getId());		
		if(cat == null)
			return null;
		
		cat.setItemName(pol.getItemName());
		if(risk != null){
			risk = riskRepo.findOne(risk.getId());
			cat.setRisk(risk);
		}
		if(!pol.getImpacts().isEmpty()){
			cat.getImpacts().clear();
			for(PriceImpacts p : pol.getImpacts()){
				PriceImpacts p1 = priceImpRepo.findOne(p.getId());
				cat.getImpacts().add(p1);
			}
		}
		cat = riskItemRepo.save(cat);
		if(!policies.isEmpty()){
			for(Policy p : policies){
				Policy temp = policyRepo.findOne(p.getId());
				temp.getRiskItems().add(cat);
				policyRepo.save(temp);
			}
		}
		return cat;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/deleteRiskItem/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteItem(@PathVariable("id") long id) {
		RiskItem cat = riskItemRepo.findOne(id);
		if(cat == null)
			return false;
		try {
			riskItemRepo.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/RiskItemByRisk/", method = RequestMethod.POST)
	@ResponseBody
	public List<RiskItem> getItemByRisk(@RequestBody Risk risk) {
		Risk r = riskRepo.findOne(risk.getId());		
		if(r == null)
			return null;
		List<RiskItem> items = riskItemRepo.findByRisk(r);
		return items;
	}
	
	
	///////////////////TODO: RISK METODE//////////////////	
	@Transactional("isokTransactionManager")
	@RequestMapping(value="/getRisks", method = RequestMethod.GET)
	@ResponseBody
	public List<Risk> getAllRisks(){
		
		List<Risk> risks = new ArrayList<Risk>();
		risks = (List<Risk>) riskRepo.findAll();
		return risks;
	}
	
	/**
	 * @param mapa koja ima objekat rizika (key="risk") i listu objekata kategorije (key="categories")
	 * */
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/saveRisk/", method = RequestMethod.POST)
	@ResponseBody
	public Risk saveRisk(@RequestBody HashMap<String,Object> risk) {
		ObjectMapper mapper = new ObjectMapper();
		Risk pol = mapper.convertValue(risk.get("risk"), Risk.class);
		System.out.println(pol.getRiskName());
		List<InsuranceCategory> categories = mapper.convertValue(risk.get("categories"),  new TypeReference<List<InsuranceCategory>>() {}); 
		
		if (pol == null)
			return null;
		pol = riskRepo.save(pol);
		
		//jer je manytomany veza namapirana sa strane kategorija
		if(!categories.isEmpty()){
			for(InsuranceCategory cat : categories){
				InsuranceCategory temp = insCatRepo.findOne(cat.getId());
				//System.out.println(temp.getCategoryName());
				//System.out.println("=====================================");
				temp.getRisks().add(pol);
				temp = insCatRepo.save(temp);
			}
		}
		return pol;
	}
	
	/**
	 * @param id - id rizika koji se menja
	 * @param mapa koja ima objekat rizika (key="risk") i listu objekata kategorije (key="categories")
	 * */
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/updateRisk/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Risk updateRisk(@PathVariable("id") long id, @RequestBody  HashMap<String,Object> risk) {
		ObjectMapper mapper = new ObjectMapper();
		Risk pol = mapper.convertValue(risk.get("risk"), Risk.class);
		List<InsuranceCategory> categories = mapper.convertValue(risk.get("categories"),  new TypeReference<List<InsuranceCategory>>() {}); 
		Risk cat = riskRepo.findOne(pol.getId());		
		if(cat == null)
			return null;		

		cat.setRiskName(pol.getRiskName());
		if(!pol.getRiskItems().isEmpty()){
			cat.getRiskItems().clear();
			for(RiskItem p : pol.getRiskItems()){
				RiskItem p1 = riskItemRepo.findOne(p.getId());
				cat.getRiskItems().add(p1);
			}
		}
		cat = riskRepo.save(cat);
		for(InsuranceCategory ins : cat.getCategories()){
			InsuranceCategory temp = insCatRepo.findOne(ins.getId());
			temp.getRisks().remove(cat);
			temp = insCatRepo.save(temp);
		}
		if(!categories.isEmpty()){
			for(InsuranceCategory ins : categories){
				InsuranceCategory temp = insCatRepo.findOne(ins.getId());
				temp.getRisks().add(cat);
				temp = insCatRepo.save(temp);
			}
		}
		return cat;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/deleteRisk/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteRisk(@PathVariable("id") long id) {
		Risk cat = riskRepo.findOne(id);
		if(cat == null)
			return false;
		try {
			for(InsuranceCategory ins : cat.getCategories()){
				InsuranceCategory temp = insCatRepo.findOne(ins.getId());
				temp.getRisks().remove(cat);
				insCatRepo.save(temp);
			}
			riskRepo.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/RiskName/", method = RequestMethod.POST)
	@ResponseBody
	public Risk getRiskByName(@RequestBody String name) {
		Risk cat = riskRepo.findByRiskName(name);
		return cat;
	}
	
	
	//////////////TODO: RULES//////////////////////
	@Transactional("isokTransactionManager")
	@RequestMapping(value="/getRules", method = RequestMethod.GET)
	@ResponseBody
	public List<Rules> getAllRules(){
		List<Rules> rules = (List<Rules>) rulesRepo.findAll();
		return rules;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/saveRule/", method = RequestMethod.POST)
	@ResponseBody
	public Rules saveRule(@RequestBody Rules rule) {
		Rules pol = rulesRepo.findOne(rule.getId());
		if (pol != null)
			return null;
		pol = rulesRepo.save(rule);
		return pol;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/updateRules/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Rules updateRule(@PathVariable("id") long id, @RequestBody Rules rule) {
		Rules cat = rulesRepo.findOne(rule.getId());		
		if(cat == null)
			return null;
		cat.setRule(rule.getRule());
		cat = rulesRepo.save(cat);
		return cat;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/deleteRule/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteRule(@PathVariable("id") long id) {
		Rules cat = rulesRepo.findOne(id);
		if(cat == null)
			return false;
		try {
			rulesRepo.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	//////////////TODO: TRAVEL INSURANCE//////////////////////
	@Transactional("isokTransactionManager")
	@RequestMapping(value="/getTravelInsurance", method = RequestMethod.GET)
	@ResponseBody
	public List<TravelInsurance> getAllTravels(){
		List<TravelInsurance> travels = (List<TravelInsurance>) travelInsRepo.findAll();
		return travels;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/saveTravelInsurance/", method = RequestMethod.POST)
	@ResponseBody
	public TravelInsurance saveTravel(@RequestBody TravelInsurance trav) {
		TravelInsurance pol = travelInsRepo.findOne(trav.getId());
		if (pol != null)
			return null;
		pol = travelInsRepo.save(trav);
		return pol;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/updateTravelInsurance/{id}", method = RequestMethod.POST)
	@ResponseBody
	public TravelInsurance updateTravel(@PathVariable("id") long id, @RequestBody TravelInsurance travel) {
		TravelInsurance cat = travelInsRepo.findOne(travel.getId());		
		if(cat == null)
			return null;
		cat.setContactMail(travel.getContactMail());
		cat.setNumOfPersons(travel.getNumOfPersons());
		cat.setPriceSum(travel.getPriceSum());
		cat = travelInsRepo.save(cat);
		return cat;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/deleteTravelInsurance/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteTravel(@PathVariable("id") long id) {
		TravelInsurance cat = travelInsRepo.findOne(id);
		if(cat == null)
			return false;
		try {
			travelInsRepo.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/TravelInsuranceMail/", method = RequestMethod.POST)
	@ResponseBody
	public List<TravelInsurance> getTravelByMail(@RequestBody String mail) {
		List<TravelInsurance> pol = travelInsRepo.findByContactMail(mail);
		return pol;
	}
	
		
	//////////////////TODO: VEHICLEINSURANCE METODE////////////////////////
	@Transactional("isokTransactionManager")
	@RequestMapping(value="/getVehicleInsurance", method = RequestMethod.GET)
	@ResponseBody
	public List<VehicleInsurance> getAllVehicles(){
		List<VehicleInsurance> travels = (List<VehicleInsurance>) vehicleInsRepo.findAll();
		return travels;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/saveVehicleInsurance/", method = RequestMethod.POST)
	@ResponseBody
	public VehicleInsurance saveVehicle(@RequestBody VehicleInsurance trav) {
		VehicleInsurance pol = vehicleInsRepo.findOne(trav.getId());
		if (pol != null)
			return null;
		pol = vehicleInsRepo.save(trav);
		return pol;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/updateVehicleInsurance/{id}", method = RequestMethod.POST)
	@ResponseBody
	public VehicleInsurance updateVehicle(@PathVariable("id") long id, @RequestBody VehicleInsurance travel) {
		VehicleInsurance cat = vehicleInsRepo.findOne(travel.getId());		
		if(cat == null)
			return null;
		cat.setBrandAndType(travel.getBrandAndType());
		cat.setChassisNum(travel.getChassisNum());
		cat.setOwnerName(travel.getOwnerName());
		cat.setOwnerSurname(travel.getOwnerSurname());
		cat.setJmbg(travel.getJmbg());
		cat.setProductionYear(travel.getProductionYear());
		cat.setRegNum(travel.getRegNum());
		cat = vehicleInsRepo.save(cat);
		return cat;
	}
	
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/deleteVehicleInsurance/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteVehicle(@PathVariable("id") long id) {
		VehicleInsurance cat = vehicleInsRepo.findOne(id);
		if(cat == null)
			return false;
		try {
			vehicleInsRepo.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Transactional("isokTransactionManager")
	@RequestMapping(value = "/VehicleInsuranceReg/", method = RequestMethod.POST)
	@ResponseBody
	public List<VehicleInsurance> getVehicle(@RequestBody String number) {
		List<VehicleInsurance> pol = vehicleInsRepo.findByRegNum(number);
		return pol;
	}
	
	@Autowired
	private RiskRepo riskRepo;
	
	@Autowired
	private ClientRepo clientRepo;
	
	@Autowired
	private HomeInsuranceRepo homeInsRepo;
	
	@Autowired
	private InsuranceCategoryRepo insCatRepo;
	
	
	@Autowired
	private PolicyRepo policyRepo;
	
	@Autowired
	private PriceImpactsRepo priceImpRepo;
	
	@Autowired
	private PricelistRepo pricelistRepo;
	
	@Autowired
	private RiskItemRepo riskItemRepo;
	
	@Autowired
	private RulesRepo rulesRepo;
	
	@Autowired
	private TravelInsuranceRepo travelInsRepo;
	
	@Autowired
	private VehicleInsuranceRepo vehicleInsRepo;
}
