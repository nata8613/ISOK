package com.PM.PMService.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.PM.PMService.KIEService;
import com.PM.PMService.models.Policy;

@RestController
public class DiscountController {

	private final KIEService KIEService;
	
	@Autowired
	public DiscountController(KIEService KIEService) {
		this.KIEService = KIEService;
	}

	@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
		public Policy getQuestions(@RequestBody Policy policy) {
		
		
		KIEService.getProductDiscount(policy);
		//	InsuranceCategory product = new InsuranceCategory();
	//	product.setId(Long.valueOf(type).longValue());
	//	KIEService.getProductDiscount(product);
		return policy;
	}
}
