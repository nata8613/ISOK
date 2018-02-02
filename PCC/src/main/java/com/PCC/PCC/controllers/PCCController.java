package com.PCC.PCC.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.PCC.PCC.models.Bank;
import com.PCC.PCC.models.DataAcqToPCC;
import com.PCC.PCC.models.DataIssToAcq;


@Controller
public class PCCController {

	private List <Bank> banke = new ArrayList<Bank>();
	
	final String ipIssuer = "192.168.1.16";
	
	@RequestMapping("/sendData")
	@ResponseBody
	public DataIssToAcq getData(@RequestBody DataAcqToPCC data){
		System.out.println("-------PCC-----------");
		initializeBanks();
		// getIssuer by PAN and return port for issuer
		System.out.println("-------PCC DATA FROM ACQUIRER------"+data.getCardHolderName());
		String port = findIssuerByPan(data.getPAN());
		System.out.println("PORT JE "+port);
		
		if(port!=null){final String url = "http://"+ipIssuer+":"+port+"/sendData";
		RestTemplate template = new RestTemplate();
		System.out.println("-------Passing data from PCC to Issuer-----------");
		DataIssToAcq payment = template.postForObject(url, data, DataIssToAcq.class);
		System.out.println("-------Passing data from PCC to Acquirer-----------");
		return payment;
		}else 
			return null;
		
		
	}
	
	public void initializeBanks(){
		banke.add(new Bank("Erste", "ERSTRS22", "123456789012365478", 30000000, "123456", "8885"));
		banke.add(new Bank("Intesa", "INTERS22", "968764589012365478", 89420000, "987456", "8886"));
		banke.add(new Bank("Telenor", "TELERS22", "356487589012365478", 56000000, "654123", "8887"));
		System.out.println("---------BANKS ADDED-----------");
	}
	
	public String findIssuerByPan(long PAN){
		for (Bank bank : banke) {
			if(bank.getPanCode().equals(Long.toString(PAN).substring(1, 7))){
				return bank.getBankPort();
			}
		}
		return null;
	}
}
