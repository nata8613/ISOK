package com.PM.PMService.controllers;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.PM.PMService.KIEService;
import com.PM.PMService.models.Policy;
import com.PM.PMService.models.TravelInsurance;

@RestController
public class DiscountController {

	private final KIEService KIEService;
	
	@Autowired
	public DiscountController(KIEService KIEService) {
		this.KIEService = KIEService;
	}

	@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
		public Policy getQuestions(@RequestBody Policy policy) {
		
		Policy polisa = new Policy();
		TravelInsurance ti = new TravelInsurance();
		ti.setContactMail("lalala@gmail.com");
		ti.setNumOfPersons(1);
		ti.setPriceSum(10000);
		polisa.setClients(null);
		polisa.setContractEnd(new Date());
		polisa.setContractStart(new Date());
		polisa.setHomeInsurance(null);
		polisa.setVehicleInsurance(null);
		polisa.setTravelInsurance(ti);
		polisa.setInsuranceOwner(null);
		polisa.setRiskItems(null);
		polisa.setPriceSummed(10000);
		KIEService.getProductDiscount(polisa);
		//	InsuranceCategory product = new InsuranceCategory();
	//	product.setId(Long.valueOf(type).longValue());
	//	KIEService.getProductDiscount(product);
		return policy;
	}
}
