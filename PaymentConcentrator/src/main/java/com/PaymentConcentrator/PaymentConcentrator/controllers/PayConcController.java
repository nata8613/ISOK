package com.PaymentConcentrator.PaymentConcentrator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.PaymentConcentrator.PaymentConcentrator.models.DataAcqToPH;
import com.PaymentConcentrator.PaymentConcentrator.models.DataPHtoPC;
import com.PaymentConcentrator.PaymentConcentrator.models.Payment;


@Controller
public class PayConcController {

	final String ip = "localhost"; 
	
	@RequestMapping("/getPaymentURLID")
	@ResponseBody
	public Payment getPaymentURLandPaymentID(@RequestBody DataPHtoPC data){
		
		final String url = "http://"+ip+":8883"+"/getPaymentURLID";
		RestTemplate template = new RestTemplate();
		
		Payment payment = template.postForObject(url, data, Payment.class);
		System.out.println("--------PaymentConcentrator got PaymentURL and PaymentID"+payment.getPaymentURL()+payment.getPaymentID());
		if(payment!=null)
		return payment;
		else return null; //ako je doslo do greske vracas null pa ga preusmeravas na error stranicu 
		
	}
	
	@RequestMapping("/sendData")
	@ResponseBody
	public boolean sendData(@RequestBody DataAcqToPH data){
		
		
		System.out.println("-------GOD DATA FROM ACQUIRER-----"+data.getPaymentId());
		final String url = "http://"+ip+":8881"+"/sendData";
		RestTemplate template = new RestTemplate();
		
		return  template.postForObject(url, data, Boolean.class);
		
		
	}
}
