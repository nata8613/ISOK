package com.PaymentHandler.PaymentHandler.controllers;

import java.util.Calendar;
import java.sql.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.PaymentHandler.PaymentHandler.models.DataAcqToPH;
import com.PaymentHandler.PaymentHandler.models.DataPHtoPC;
import com.PaymentHandler.PaymentHandler.models.MerchLicense;
import com.PaymentHandler.PaymentHandler.models.Order;
import com.PaymentHandler.PaymentHandler.models.Payment;
import com.PaymentHandler.PaymentHandler.models.Transaction;



@Controller
public class PaymentHandlerController {

	//NIJE SAMO OVDE SEARCH LOCALHOST
	final String ip = "192.168.1.16"; 
	final String ipDB = "192.168.1.17";
	
	//metoda koja generise podatke koje salje Payment Concentrator-u i 
	//kojoj Payment Concetrator vraca URL(ID) stranice Acquirer-a
	@RequestMapping("/getPaymentURLID")
	@ResponseBody
	public String getPaymentURLandPaymentID(@RequestParam("amount") double amount){
		
		
		
		final String url = "http://"+ip+":8882"+"/getPaymentURLID";
		final String urlDC = "http://"+ipDB+":8080"+"/dc/pcc/saveTransaction/";
		
		RestTemplate template = new RestTemplate();	
		RestTemplate template1 = new RestTemplate();
		
		//generisanje podataka za Acquirer-a
		System.out.println("************amount je *********"+amount);
		DataPHtoPC data = generateDataForPC(amount);
		
		System.out.println("----------------DataForPC in PaymentHandler created---------------");
		Payment payment = template.postForObject(url, data, Payment.class);
		
		System.out.println("-----PaymentHandler got "+payment.getPaymentURL() +"payment URL and" + payment.getPaymentID()+"payment ID-----");
		
		String paymentIDandURL = payment.getPaymentURL()+payment.getPaymentID();
		String paymentID = Long.toString(payment.getPaymentID());
		
		
		Transaction transakcija = new Transaction();
		transakcija.setAmount((new Double(amount)).longValue());
		transakcija.setAcquirerOrderId(0L);
		transakcija.setAcquirerOrderTimestamp(null);
		transakcija.setPaymentId(Long.parseLong(paymentID));
		transakcija.setMerchantOrderId(data.getOrder().getOrderId());
		transakcija.setMerchantOrderTimestamp(data.getOrder().getTimestamp());
		transakcija.setStatus("zapoceta");
		System.out.println("salje se transackija"+transakcija.getStatus());
		Transaction transaction = template1.postForObject(urlDC, transakcija, Transaction.class);
		System.out.println("----------------------Transaction for DC created zapoceta-------------------------");
		
		return paymentID;
		
	}
	
	public DataPHtoPC generateDataForPC(double amount){
		
		//Kreiramo i cuvamo novu transakciju/ proveravamo merchantID 
		Transaction transakcija = new Transaction();
		Random rand = new Random();
		
		MerchLicense license = new MerchLicense("123456789", "IsokPassword");
		
		//TODO: proveri da li se merchantID nalazi u bazi
		final String urlDC = "http://"+ipDB+":8080"+"/getTransactionMerchantOrder";	
		RestTemplate template = new RestTemplate();	
		
			boolean out = false;
			do{
				
			try {
				transakcija = template.postForObject(urlDC, rand.nextLong(), Transaction.class);
			} catch (RestClientException e) {
				System.out.println("PA PUKO SAM :D");
				e.printStackTrace();
			}
			if(transakcija!=null)out = true;
			rand = new Random();
			}
			while(!out);
		
		long MerchID = rand.nextLong();
		if(MerchID<0){MerchID= 0-MerchID;}
		Order merchOrder = new Order(amount, MerchID, new Date(Calendar.getInstance().getTimeInMillis()));
		
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
		
		
		final String urlFrom = "http://"+ipDB+":8080/dc/pcc/getTransactionMerchantOrder/";
		RestTemplate template = new RestTemplate();
		//TODO SEND DATA TO PCC DATABASE
		System.out.println("-----------GOT DATA FROM CONCENTRATOR--------"+data.getPaymentId()+data.getResult());
		System.out.println("------------------OVDE SALJI PODATKE U ISOK DATABASE-------------------");
		Transaction transakcija = template.postForObject(urlFrom, data.getMerchantOrderId(), Transaction.class);
		
		final String urlTo = "http://"+ipDB+":8080/dc/pcc/updateTransaction/"+transakcija.getTransactionId();
		RestTemplate template1 = new RestTemplate();	
		transakcija.setAcquirerOrderId(data.getAcquirerOrderId());
		transakcija.setAcquirerOrderTimestamp(data.getAcquirerTimestamp());
		transakcija.setStatus("proknjizeno");
		Transaction merchID = template1.postForObject(urlTo, transakcija, Transaction.class);
		
		return true;
		
		
	}
	
	
}
