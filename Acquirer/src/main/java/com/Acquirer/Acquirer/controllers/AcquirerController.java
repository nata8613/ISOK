package com.Acquirer.Acquirer.controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.Acquirer.Acquirer.models.Client;
import com.Acquirer.Acquirer.models.DataAcqToPCC;
import com.Acquirer.Acquirer.models.DataAcqToPH;
import com.Acquirer.Acquirer.models.DataIssToAcq;
import com.Acquirer.Acquirer.models.DataPCtoPH;
import com.Acquirer.Acquirer.models.Merchant;
import com.Acquirer.Acquirer.models.Payment;
import com.Acquirer.Acquirer.models.Transaction;
import com.Acquirer.Acquirer.repo.ClientRepo;
import com.Acquirer.Acquirer.repo.MerchantRepo;
import com.Acquirer.Acquirer.repo.TransactionRepo;


@Controller
public class AcquirerController {
	
	@Autowired
	private MerchantRepo mr;
	
	@Autowired
	private TransactionRepo tr;
	
	@Autowired
	private ClientRepo cr;

	final String ip = "localhost"; 
	
	//metoda za vracanje linka ka acquirer web aplikaciji za unos podataka
	@RequestMapping("/getPaymentURLID")
	@ResponseBody
	public Payment generatePaymentURLandPaymentID(@RequestBody DataPCtoPH data){
		
		//TODO ubaciti sifrovanje passworda
		Merchant merch = mr.findByMerchantIdAndMerchantPassword(data.getMerchantLicense().getMerchantId(), data.getMerchantLicense().getMerchantPassword());
		
		if(merch!=null){
		Random rand = new Random();
		long PayID = rand.nextLong();
		Transaction transakcija = tr.findByPaymentID(PayID);
		if(transakcija!=null){
			Random rand1 = new Random();
			PayID = rand1.nextLong();
		}
		//TODO izmeni url ako Mica stavi nesto drugo
		Payment payment = new Payment("https://"+ip+":4022/Acquirer", PayID);
		System.out.println("---------Acquirer created PaymentURL and PaymentID"+payment.getPaymentURL()+payment.getPaymentID());
		
		Transaction transaction = new Transaction();
		transaction.setAcquirerId(null);
		transaction.setAcquirerTimestamp(null);
		transaction.setAmount(data.getOrder().getAmount());
		transaction.setMerchant(merch);
		transaction.setPaymentID(PayID);
		transaction.setStatus("zapoceta");
		transaction.setMerchantOrderId(data.getOrder().getOrderId());
		
		
		tr.save(transaction);
		
		return payment;
		}else {
			return null;	
		}
		
	}
	
	//metoda za unos podataka preko acquirer web aplikacije
	@RequestMapping("/getData")
	@ResponseBody
//	public DataIssToAcq getData(@PathVariable("id") long id, @RequestBody DataAcqToPCC data){
		public DataIssToAcq getData(@RequestParam("var") String var){	
		Long id = Long.parseLong(var);
		DataAcqToPCC data = new DataAcqToPCC();
		data.setAcquirerOrderId(Long.parseLong("1110529899157111111"));
		data.setAcquirerTimestamp(new Date(Calendar.getInstance().getTime().getTime()));
		data.setPAN(Long.parseLong("2123456654789874"));
		data.setSecuityCode(123);
		data.setValidDate(new Date(118, 5, 30));
		System.out.println("DATUM ZA GETDATA U ACQUIRER-U JE"+ data.getValidDate());
		data.setCardHolderName("Sinisa Sinisic");
		data.setAmount(tr.findByPaymentID(Long.parseLong("69291033783164944")).getAmount());
		
		
		String pan = Long.toString(data.getPAN());
		String banka = pan.substring(1, 7);
		
		Transaction transaction = tr.findByPaymentID(id);
		transaction.setAcquirerId(Long.toString(data.getAcquirerOrderId()));
		transaction.setAcquirerTimestamp(data.getAcquirerTimestamp());
		tr.save(transaction);
		
		//ako je kartica kupca osiguranja iz banke u kojoj se nalazi i prodavac tj isok onda se vrsi settlement
		if(banka!="704521"){
			
			System.out.println("------------Sending data from Acquirer to PCC---------");
			final String url = "http://"+ip+":8884"+"/sendData";
			RestTemplate template = new RestTemplate();
			
			System.out.println("-----------Card Holder Name --------"+data.getCardHolderName());
			DataIssToAcq returnData = template.postForObject(url, data, DataIssToAcq.class);
			
			System.out.println("-----------Retrieving data from PCC to Acquirer.----------- "
					+ "Retrieved data result:"+ returnData.getResult());
			
			System.out.println("-----------Generating DataForPH-------------");
			DataAcqToPH dataForPH = new DataAcqToPH();
			dataForPH.setAcquirerOrderId(returnData.getAcquirerOrderId());
			dataForPH.setAcquirerTimestamp(returnData.getAcquirerTimestamp());
			dataForPH.setMerchantOrderId(transaction.getMerchantOrderId());
			dataForPH.setPaymentId(id);
			dataForPH.setResult("SUCCESS_URL");
			sendDataToPH(dataForPH);
			return returnData;
			
		}else{
			if(settlement(data)){
				DataAcqToPH returnData = new DataAcqToPH();
				returnData.setAcquirerOrderId(data.getAcquirerOrderId());
				returnData.setAcquirerTimestamp(data.getAcquirerTimestamp());
				returnData.setMerchantOrderId(transaction.getMerchantOrderId());
				returnData.setPaymentId(id);
				sendDataToPH( returnData);
				
			}
			return null;
		}
		
	}
	
	public boolean settlement(DataAcqToPCC data){
		
		Client client = cr.findByAccountNumberAndCardHolderNameAndSecurityCodeAndValidTo(data.getPAN(), data.getCardHolderName(), data.getSecuityCode(), data.getValidDate());
		System.out.println("Client from Acquirer Bank:" +client.getCardHolderName() +"found");
		
		if(client.getBalance()> data.getAmount()){
		client.setBalance(client.getBalance()-data.getAmount());
		Client klijent = cr.save(client);
		
		System.out.println("--------------Settlement for client:"+klijent.getCardHolderName()+"done!");
		}else{
			return false;
		}
		return true;
	}
	
	public boolean sendDataToPH(DataAcqToPH dataForPH){
		
		final String url = "http://"+ip+":8882"+"/sendData";
		RestTemplate template = new RestTemplate();
		
		System.out.println("-----------SENDING DATAFORPH TO CONENTRATOR");
		return template.postForObject(url, dataForPH, Boolean.class);
	
	}
}
