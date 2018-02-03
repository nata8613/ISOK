package com.Acquirer.Acquirer.controllers;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.Acquirer.Acquirer.EncryptDecrypt;
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
@CrossOrigin("*")
public class AcquirerController {
	
	@Autowired
	private MerchantRepo mr;
	
	@Autowired
	private TransactionRepo tr;
	
	@Autowired
	private ClientRepo cr;

	final String ipConcentrator = "192.168.1.16"; 
	final String ipPcc = "192.168.1.16";

	
	//httpss://javapointers.com/tutorial/how-to-encrypt-and-decrypt-using-aes-in-java/
	@RequestMapping("/setup")
	@ResponseBody
	public String sifrovanje() throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		String sifra = "Natasa";
		
		EncryptDecrypt sifrovanje = new EncryptDecrypt();
		String sifrovano = sifrovanje.encrypt(sifra);
		System.out.println("*************************ENKRIPTOVANJE*********"+sifrovano);
		String desifrovano = sifrovanje.decrypt(sifrovano);
		System.out.println("------------------------DESIFROVANO------"+desifrovano);
		
		
		return sifra;
	}
	//metoda za vracanje linka ka acquirer web aplikaciji za unos podataka
	@RequestMapping("/getPaymentURLID")
	@ResponseBody
	public Payment generatePaymentURLandPaymentID(@RequestBody DataPCtoPH data) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		
		boolean found = false;
		//TODO ubaciti sifrovanje passworda
		Merchant merch = mr.findByMerchantIdAndMerchantPassword(data.getMerchantLicense().getMerchantId(), data.getMerchantLicense().getMerchantPassword());
		
	//	EncryptDecrypt encDec = new EncryptDecrypt(); 
	//	if(data.getMerchantLicense().getMerchantPassword().equals(encDec.decrypt(merch.getMerchantPassword()))){
	//		found = true;
	//	}
	//	if(found){
		if(merch!=null){
		/*Random rand = new Random();
			long PayID = rand.nextLong();
			Transaction transakcija = tr.findByPaymentID(PayID);
			if(transakcija!=null){
				Random rand1 = new Random();
				PayID = rand1.nextLong();
			}*/
			Transaction transakcija = new Transaction();
			Random rand = new Random();
			boolean out = false;
			do{
			transakcija = tr.findByPaymentID(rand.nextLong());
			if(transakcija==null)out = true;
			rand = new Random();
			}
			while(!out);
			
			long PayID = rand.nextLong();
			if(PayID<0){PayID= 0-PayID;}
			//TODO izmeni url ako Mica stavi nesto drugo
			//Payment payment = new Payment("http://"+ip+":4300/Payment/", PayID);
			Payment payment = new Payment("http://localhost:4300/Payment/", PayID);
			System.out.println("---------Acquirer created PaymentURL and PaymentID"+payment.getPaymentURL()+payment.getPaymentID());
			
			Transaction transaction = new Transaction();
			transaction.setAcquirerId(null);
			transaction.setAcquirerTimestamp(null);
			transaction.setAmount(data.getOrder().getAmount());
			transaction.setMerchant(merch);
			long payID = PayID%1000;
			long pp = payment.getPaymentID()-payID;
			payment.setPaymentID(pp);
			String paymentID = Long.toString(pp);
			transaction.setPaymentID(pp);
			transaction.setStatus("zapoceta");
			transaction.setMerchantOrderId(data.getOrder().getOrderId());
			
			
			tr.save(transaction);
			
			return payment;
		}else {
			return null;	
		}
		
	}
	
	//metoda za unos podataka preko acquirer web aplikacije
	@RequestMapping("/getData/")
	@ResponseBody
	public DataIssToAcq getData(@RequestParam("id") long id, @RequestBody DataAcqToPCC data){
		System.out.println("*************Web app*******************");
	/*	public DataIssToAcq getData(@RequestParam("var") String var){	
		Long id = Long.parseLong(var);
		DataAcqToPCC data = new DataAcqToPCC();
		data.setAcquirerOrderId(Long.parseLong("444429899157222222"));
		data.setAcquirerTimestamp(new Date(Calendar.getInstance().getTime().getTime()));
		data.setPAN(Long.parseLong("2123456654789874"));
		data.setSecuityCode(123);
		data.setValidDate(new Date(118, 5, 30));
		System.out.println("DATUM ZA GETDATA U ACQUIRER-U JE"+ data.getValidDate());
		data.setCardHolderName("Sinisa Sinisic");
		data.setAmount(tr.findByPaymentID(Long.parseLong("6538047422558411908")).getAmount());
		*/
		System.out.println("ID TRANSAKCIJE 2222222222" + id);
		System.out.println("TRANSAKCIJAAAA///////////////"+tr.findByPaymentID(id));
		data.setAmount(tr.findByPaymentID(id).getAmount());
		String pan = Long.toString(data.getPAN());
		String banka = pan.substring(1, 7);
		
		Transaction transaction = tr.findByPaymentID(id);
		System.out.println("************TRANSAKCIJA -*---------------"+transaction.getAcquirerId()+"****"+transaction.getMerchantOrderId()+"***"+transaction.getPaymentID());
		if(transaction.getAcquirerId()!=null)return null;
		transaction.setAcquirerId(Long.toString(data.getAcquirerOrderId()));
		transaction.setAcquirerTimestamp(data.getAcquirerTimestamp());
		tr.save(transaction);
		
		//ako je kartica kupca osiguranja iz banke u kojoj se nalazi i prodavac tj isok onda se vrsi settlement
		if(banka!="704521"){
			
			System.out.println("------------Sending data from Acquirer to PCC---------");
			final String url = "http://"+ipPcc+":8884"+"/sendData";
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
			transaction.setStatus("proknjizeno");
			tr.save(transaction);
			sendDataToPH(dataForPH);
			return returnData;
			
		}else{
			if(settlement(data)){
				DataAcqToPH returnData = new DataAcqToPH();
				returnData.setAcquirerOrderId(data.getAcquirerOrderId());
				returnData.setAcquirerTimestamp(data.getAcquirerTimestamp());
				returnData.setMerchantOrderId(transaction.getMerchantOrderId());
				returnData.setPaymentId(id);
				transaction.setStatus("proknjizeno");
				tr.save(transaction);
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
		
		final String url = "http://"+ipConcentrator+":8882"+"/sendData";
		RestTemplate template = new RestTemplate();
		
		System.out.println("--------------DATAACQTOPH-----------"+dataForPH.getResult());
		System.out.println("-----------SENDING DATAFORPH TO CONENTRATOR");
		return template.postForObject(url, dataForPH, Boolean.class);
	
	}
}
