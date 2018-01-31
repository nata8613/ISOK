package com.PaymentHandler.PaymentHandler.controllers;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.PaymentHandler.PaymentHandler.models.DataAcqToPH;
import com.PaymentHandler.PaymentHandler.models.DataPHtoPC;
import com.PaymentHandler.PaymentHandler.models.MerchLicense;
import com.PaymentHandler.PaymentHandler.models.Order;
import com.PaymentHandler.PaymentHandler.models.Payment;



@Controller
public class PaymentHandlerController {

	final String ip = "localhost"; 
	
	//metoda koja generise podatke koje salje Payment Concentrator-u i 
	//kojoj Payment Concetrator vraca URL(ID) stranice Acquirer-a
	@RequestMapping("/getPaymentURLID")
	@ResponseBody
	public Payment getPaymentURLandPaymentID(@RequestParam("amount") double amount){
		
		final String url = "http://"+ip+":8882"+"/getPaymentURLID";
		RestTemplate template = new RestTemplate();	
		DataPHtoPC data = generateDataForPC(amount);
		System.out.println("----------------DataForPC in PaymentHandler created---------------");
		Payment payment = template.postForObject(url, data, Payment.class);
		System.out.println("-----PaymentHandler got "+payment.getPaymentURL() +"payment URL and" + payment.getPaymentID()+"payment ID-----");
		return payment;
		
	}
	
	public DataPHtoPC generateDataForPC(double amount){
		
		Random rand = new Random();
		MerchLicense license = new MerchLicense("123456789", "IsokPassword");
		//TODO: proveri da li se merchantID nalazi u bazi
		Order merchOrder = new Order(amount, rand.nextLong(), new Date());
		
		//TODO: sacuvaj u bazu merchOrder
		DataPHtoPC data = new DataPHtoPC();
		data.setMerchantLicense(license);
		data.setOrder(merchOrder);
		data.setError_url("http://"+ip+":8880/error");
		
		return data;
	}
	
	@RequestMapping("/sendData")
	@ResponseBody
	public boolean sendData(@RequestBody DataAcqToPH data){
		
		//TODO SEND DATA TO PCC DATABASE
		System.out.println("-----------GOT DATA FROM CONCENTRATO--------"+data.getPaymentId()+data.getResult());
		System.out.println("------------------OVDE SALJI PODATKE U ISOK DATABASE-------------------");
		
		return true;
		
		
	}
	
}
