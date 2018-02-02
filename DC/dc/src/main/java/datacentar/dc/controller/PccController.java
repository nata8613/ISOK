package datacentar.dc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import datacentar.dc.pcc.model.MerchantLicense;
import datacentar.dc.pcc.model.Transactions;
import datacentar.dc.pcc.repo.MerchantLicenseRepo;
import datacentar.dc.pcc.repo.TransactionsRepo;

@Controller
@RequestMapping("/dc/pcc")
public class PccController {

	
	/////////////////LICENSE METODE///////////////////
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getMerchantLicense", method = RequestMethod.GET)
	@ResponseBody
	public MerchantLicense getLicense() {
		List<MerchantLicense> merchants = (List<MerchantLicense>) merchLicRepo.findAll();
		return merchants.get(0);
	}
		
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/saveMerchantLicense/", method = RequestMethod.POST)
	@ResponseBody
	public MerchantLicense saveMerchantLicense(@RequestBody MerchantLicense merchant) {
		
		MerchantLicense merch1 = merchLicRepo.findOne(merchant.getId());
		if(merch1 != null)
			return null;
		merch1 = merchLicRepo.save(merchant);
		return merch1;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/updateMerchantLicense/{id}", method = RequestMethod.POST)
	@ResponseBody
	public MerchantLicense updateMerchantLicense(@PathVariable("id") long id, @RequestBody MerchantLicense license) {
		
		MerchantLicense merch1 = merchLicRepo.findOne(id);
		if(merch1 == null)
			return null;
		merch1.setMerchantId(license.getMerchantId());
		merch1.setMerchantPass(license.getMerchantPass());
		merch1 = merchLicRepo.save(merch1);
		return merch1;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/deleteMerchant/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteMerchantLicense(@PathVariable("id") long id) {
		
		MerchantLicense merchant = merchLicRepo.findOne(id);
		if(merchant == null)
			return false;
		try {
			merchLicRepo.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	////////////////////////TRANSACTION METODE////////////////////
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getTransactions", method = RequestMethod.GET)
	@ResponseBody
	public List<Transactions> getAllTransactions() {
		List<Transactions> transactions = new ArrayList<Transactions>();
		transactions = (List<Transactions>) transactionsRepo.findAll();
		return transactions;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/saveTransaction/", method = RequestMethod.POST)
	@ResponseBody
	public Transactions saveTransaction(@RequestBody Transactions transaction) {
		
		Transactions trans = transactionsRepo.findOne(transaction.getTransactionId());
		if(trans != null)
			return null;
		trans = transactionsRepo.save(transaction);
		return trans;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/updateTransaction/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Transactions updateMerchant(@PathVariable("id") long id, @RequestBody Transactions transaction) {
		
		Transactions transaction1 = transactionsRepo.findOne(transaction.getTransactionId());
		if(transaction1 == null)
			return null;
		transaction1.setAmount(transaction.getAmount());
		transaction1.setAcquirerOrderId(transaction.getAcquirerOrderId());
		transaction1.setAcquirerOrderTimestamp(transaction.getMerchantOrderTimestamp());
		transaction1.setMerchantOrderId(transaction.getMerchantOrderId());
		transaction1.setMerchantOrderTimestamp(transaction.getMerchantOrderTimestamp());
		transaction1.setPaymentId(transaction.getPaymentId());
		transaction1.setStatus(transaction.getStatus());
		transaction1 = transactionsRepo.save(transaction1);
		return transaction1;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/deleteTransaction/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteTransaction(@PathVariable("id") long id) {
		
		Transactions transaction = transactionsRepo.findOne(id);
		if(transaction == null)
			return false;
		try {
			transactionsRepo.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getTransactionMerchantOrder/", method = RequestMethod.POST)
	@ResponseBody
	public Transactions getTransactionByMerchantOrder(@RequestBody long orderId) {
		Transactions transaction = transactionsRepo.findByMerchantOrderId(orderId);
		return transaction;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getTransactionAcquirerOrder/", method = RequestMethod.POST)
	@ResponseBody
	public Transactions getTransactionByAcquirerOrder(@RequestBody long orderId) {
		Transactions transaction = transactionsRepo.findByAcquirerOrderId(orderId);
		return transaction;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getTransactionPayment/", method = RequestMethod.POST)
	@ResponseBody
	public Transactions getTransactionByPayment(@RequestBody long orderId) {
		Transactions transaction = transactionsRepo.findByPaymentId(orderId);
		return transaction;
	}
	
	
	@Autowired
	private MerchantLicenseRepo merchLicRepo;
	
	@Autowired
	private TransactionsRepo transactionsRepo;
}
