package com.Issuer.Issuer.controllers;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Issuer.Issuer.models.Client;
import com.Issuer.Issuer.models.DataAcqToPCC;
import com.Issuer.Issuer.models.DataIssToAcq;
import com.Issuer.Issuer.models.Transaction;
import com.Issuer.Issuer.repo.ClientRepo;
import com.Issuer.Issuer.repo.TransactionRepo;

@Controller
public class IssuerController {

	@Autowired
	private ClientRepo cr;
	
	@Autowired
	private TransactionRepo tr;
	
	final String ip = "localhost";
	
	@RequestMapping("/sendData")
	@ResponseBody
	public DataIssToAcq getData(@RequestBody DataAcqToPCC data){
		
		if(validateRequest(data)){
			System.out.println("Request validated");
			//ako je validacija prosla kreiramo novi model koji vracamo Acquirer-u preko PCC-a
			System.out.println("---------------Creating DataIssToAcq--------------------");
			
			Transaction transakcija = new Transaction();
			Random rand = new Random();
			boolean out = false;
			do{
			transakcija = tr.findByIssuerId(rand.nextLong());
			if(transakcija==null)out = true;
			rand = new Random();
			}
			while(!out);
			
			DataIssToAcq returnData = new DataIssToAcq();
			returnData.setAcquirerOrderId(data.getAcquirerOrderId());
			returnData.setAcquirerTimestamp(data.getAcquirerTimestamp());
			returnData.setIssuerOrderId(rand.nextLong());
			returnData.setIssuerTimestamp(new Date());
			returnData.setResult("SUCCESS_URL");
			System.out.println("--------------ISSUER-------DataIsstoAcq Created------SUCCESS");
			return returnData;
		}else
			return null;
		
	}
	
	public boolean validateRequest(DataAcqToPCC data){
		Client client = cr.findByAccountNumberAndCardHolderNameAndSecurityCodeAndValidTo(data.getPAN(), data.getCardHolderName(), data.getSecuityCode(), data.getValidDate());
		if((client.getBalance()- client.getReserved())>data.getAmount()){
			client.setReserved(client.getReserved()+data.getAmount());
			cr.save(client);
			System.out.println(data.getAmount() +"is reserved for client"+client.getCardHolderName()+"in issuer service");
		}
		return true;
	}
}
