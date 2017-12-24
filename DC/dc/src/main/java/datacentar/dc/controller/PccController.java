package datacentar.dc.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import datacentar.dc.pcc.model.Bank;
import datacentar.dc.pcc.model.CreditCard;
import datacentar.dc.pcc.model.Merchant;
import datacentar.dc.pcc.model.Orders;
import datacentar.dc.pcc.model.Transactions;
import datacentar.dc.pcc.repo.BankRepo;
import datacentar.dc.pcc.repo.CreditCardRepo;
import datacentar.dc.pcc.repo.MerchantRepo;
import datacentar.dc.pcc.repo.OrdersRepo;
import datacentar.dc.pcc.repo.TransactionsRepo;

@Controller
@RequestMapping("/dc/pcc")
public class PccController {

	////////////////////// INICIJALNO ZA TESTIRANJE -> TREBA IZBRISATI AKO
	////////////////////// KONEKCIJA 100% RADI
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/testPcc", method = RequestMethod.GET)
	@ResponseBody
	public List<Bank> testPcc() {
		List<Bank> banks = new ArrayList<Bank>();
		banks = (List<Bank>) bankRepo.findAll();
		return banks;
	}

	
	
	//////////////////////// BANK METODE////////////////////////

	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getBanks", method = RequestMethod.GET)
	@ResponseBody
	public List<Bank> getAllBanks() {
		List<Bank> banks = new ArrayList<Bank>();
		banks = (List<Bank>) bankRepo.findAll();
		return banks;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getBanks/{name}", method = RequestMethod.POST)
	public @ResponseBody List<Bank> getBanksByName(@RequestParam("name") String name) {
		System.out.println("Prosledjeno " + name );
		List<Bank> banks = new ArrayList<Bank>();
		banks = (List<Bank>) bankRepo.findByNameContaining(name);
		return banks;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getBankSwift/{swift}", method = RequestMethod.POST)
	@ResponseBody
	public Bank getBankBySwift(@PathVariable("swift") String swift) {
		Bank bank = bankRepo.findBySwiftCode(swift);
		return bank;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getBankCode/{code}", method = RequestMethod.POST)
	@ResponseBody
	public Bank getBankByCode(@PathVariable("code") String code) {
		int codeInt = Integer.parseInt(code);
		Bank bank = bankRepo.findByCode(codeInt);
		return bank;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getBankAcc/{account}", method = RequestMethod.POST)
	@ResponseBody
	public Bank getBankByAccount(@PathVariable("account") String account) {
		Bank bank = bankRepo.findByBillingAccount(account);
		return bank;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/saveBank/", method = RequestMethod.POST)
	@ResponseBody
	public Bank saveBank(@RequestBody Bank bank) {
		System.out.println(bank.getName());
		
		/*Bank bank1 = new Bank();
		bank1.setBillingAccount(bank.getBillingAccount());
		bank1.setCode(bank.getCode());
		bank1.setSwiftCode(bank.getSwiftCode());
		bank1.setName(bank.getName());
		bank1 = bankRepo.save(bank1);*/
		Bank bank1 = new Bank();
		bank1 = bankRepo.findOne(bank.getBankID());
		if(bank1 != null)
			return null;
		bank1 = bankRepo.save(bank);
		System.out.println(bank1.getBankID());
		return bank1;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/updateBank/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Bank updateBank(@PathVariable("id") long id, @RequestBody Bank bank) {
		
		Bank bank1 = bankRepo.findOne(id);
		if(bank1 == null)
			return null;
		bank1.setBillingAccount(bank.getBillingAccount());
		bank1.setCode(bank.getCode());
		bank1.setName(bank.getName());
		bank1.setSwiftCode(bank.getSwiftCode());
		bank1 = bankRepo.save(bank1);
		return bank1;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/deleteBank/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteBank(@PathVariable("id") long id) {
		
		Bank bank1 = bankRepo.findOne(id);
		if(bank1 == null)
			return false;
		try {
			bankRepo.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	/////////////////MERCHANT METODE///////////////////
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getMerchants", method = RequestMethod.GET)
	@ResponseBody
	public List<Merchant> getAllMerchants() {
		List<Merchant> merchants = new ArrayList<Merchant>();
		merchants = (List<Merchant>) merchantRepo.findAll();
		return merchants;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getMerchantID/{id}", method = RequestMethod.POST)
	@ResponseBody
	public List<Merchant> getMerchantsByMerchantID(@PathVariable("id") String id) {
		
		List<Merchant> merchants = merchantRepo.findByMerchantID(id);
		return merchants;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getMerchantPass/{pass}", method = RequestMethod.POST)
	@ResponseBody
	public List<Merchant> getMerchantsByMerchantPass(@PathVariable("pass") String pass) {
		
		List<Merchant> merchants = merchantRepo.findByMerchantPassword(pass);
		return merchants;
	}

	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getMerchantPassID/", method = RequestMethod.POST)
	@ResponseBody
	public Merchant getMerchantsByMerchantIDAndPass(@RequestBody Merchant merchant) {
		
		Merchant merchantReturn = merchantRepo.findByMerchantIDAndMerchantPassword(merchant.getMerchantID(),
				merchant.getMerchantPassword());
		return merchantReturn;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getMerchantBank/", method = RequestMethod.POST)
	@ResponseBody
	public List<Merchant> getMerchantsByBank(@RequestBody Bank bank) {
		
		List<Merchant> merchants = merchantRepo.findByBank(bank);
		return merchants;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/saveMerchant/", method = RequestMethod.POST)
	@ResponseBody
	public Merchant saveMerchant(@RequestBody Merchant merchant) {
		
		Merchant merch1 = merchantRepo.findOne(merchant.getId());
		if(merch1 != null)
			return null;
		merch1 = merchantRepo.save(merchant);
		return merch1;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/updateMerchant/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Merchant updateMerchant(@PathVariable("id") long id, @RequestBody Merchant merchant) {
		
		Bank bank1 = bankRepo.findOne(merchant.getBank().getBankID());
		Merchant merch1 = merchantRepo.findOne(id);
		if(merch1 == null)
			return null;
		merch1.setMerchantID(merchant.getMerchantID());
		merch1.setMerchantPassword(merchant.getMerchantPassword());
		if(bank1 != null)
			merch1.setBank(bank1);
		merch1 = merchantRepo.save(merch1);
		return merch1;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/deleteMerchant/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteMerchant(@PathVariable("id") long id) {
		
		Merchant merchant = merchantRepo.findOne(id);
		if(merchant == null)
			return false;
		try {
			merchantRepo.delete(id);
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
		
		Transactions trans = transactionsRepo.findOne(transaction.getTransactionID());
		if(trans != null)
			return null;
		trans = transactionsRepo.save(transaction);
		return trans;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/updateTransaction/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Transactions updateMerchant(@PathVariable("id") long id, @RequestBody Transactions transaction) {
		
		Transactions transaction1 = transactionsRepo.findOne(transaction.getTransactionID());
		if(transaction1 == null)
			return null;
		if(transaction.getMerchant() != null){
			Merchant merch1 = merchantRepo.findOne(transaction.getMerchant().getId());
			if(merch1 == null)
				return null;
			transaction1.setMerchant(merch1);
		}
		if(transaction.getOrder() != null){
			Orders order = ordersRepo.findOne(transaction.getOrder().getOrderID());
			if(order != null)
				transaction.setOrder(order);
			else
				return null;
		}
		if(transaction.getAcquirer() != null){
			Bank acquirer = bankRepo.findOne(transaction.getAcquirer().getBankID());
			if(acquirer != null)
				transaction1.setAcquirer(acquirer);
			
		}
		if(transaction.getIssuer() != null){
			Bank issuer = bankRepo.findOne(transaction.getIssuer().getBankID());
			if(issuer != null)
				transaction1.setIssuer(issuer);	
		}
		transaction1.setPaymentID(transaction.getPaymentID());
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
	@RequestMapping(value = "/getTransactionOrder/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Transactions getTransactionByOrder(@PathVariable("id") long orderId) {
		
		Orders order = ordersRepo.findOne(orderId);
		if (order == null)
			return null;
		Transactions transaction = transactionsRepo.findByOrderNum(order);
		return transaction;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getTransactionAcquirer/", method = RequestMethod.POST)
	@ResponseBody
	public List<Transactions> getTransactionAcquirer(@RequestBody Bank acquirer) {
		
		Bank aquirer = bankRepo.findOne(acquirer.getBankID());
		if(aquirer == null)
			return null;
		List<Transactions> transactions = transactionsRepo.findByAcquirer(aquirer);
		return transactions;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getTransactionIssuer/", method = RequestMethod.POST)
	@ResponseBody
	public List<Transactions> getTransactionIssuer(@RequestBody Bank issuer) {
		
		Bank issur = bankRepo.findOne(issuer.getBankID());
		if(issur == null)
			return null;
		List<Transactions> transactions = transactionsRepo.findByAcquirer(issur);
		return transactions;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getTransactionAcquirerAndIssuer/", method = RequestMethod.POST)
	@ResponseBody
	public List<Transactions> getTransactionAcquirerAndIssuer(@RequestBody Transactions trans) {
		
		if(trans.getAcquirer() != null && trans.getIssuer() != null){
			Bank aquirer = bankRepo.findOne(trans.getAcquirer().getBankID());
			Bank issuer = bankRepo.findOne(trans.getIssuer().getBankID());
			List<Transactions> transactions = transactionsRepo.findByAcquirerAndIssuer(aquirer, issuer);
			return transactions;
		}
		
		return null;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getTransactionMerchant/", method = RequestMethod.POST)
	@ResponseBody
	public List<Transactions> getTransactionMerchant(@RequestBody Merchant merchant) {
		
		if(merchant != null ){
			Merchant merch = merchantRepo.findOne(merchant.getId());
			List<Transactions> transactions = transactionsRepo.findByMerchant(merch);
			return transactions;
		}
		return null;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getTransactionMerchantAcq/", method = RequestMethod.POST)
	@ResponseBody
	public List<Transactions> getTransactionAcquirerAndMerchant(@RequestBody Transactions trans) {
		
		if(trans.getAcquirer() != null && trans.getMerchant() != null){
			Bank aquirer = bankRepo.findOne(trans.getAcquirer().getBankID());
			Merchant merch = merchantRepo.findOne(trans.getMerchant().getId());
			List<Transactions> transactions = transactionsRepo.findByMerchantAndAcquirer(merch, aquirer);
			return transactions;
		}
		return null;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getTransactionMerchantIss/", method = RequestMethod.POST)
	@ResponseBody
	public List<Transactions> getTransactionIssuerAndMerchant(@RequestBody Transactions trans) {
		
		if(trans.getIssuer() != null && trans.getMerchant() != null){
			Bank issuer = bankRepo.findOne(trans.getIssuer().getBankID());
			Merchant merch = merchantRepo.findOne(trans.getMerchant().getId());
			List<Transactions> transactions = transactionsRepo.findByMerchantAndIssuer(merch, issuer);
			return transactions;
		}
		return null;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getTransactionMerchantAcqAndIss/", method = RequestMethod.POST)
	@ResponseBody
	public List<Transactions> getTransactionAcquirerAndIssuerAndMerchant(@RequestBody Transactions trans) {
		
		if(trans.getAcquirer() != null && trans.getIssuer() != null && trans.getMerchant() != null){
			Bank aquirer = bankRepo.findOne(trans.getAcquirer().getBankID());
			Bank issuer = bankRepo.findOne(trans.getIssuer().getBankID());
			Merchant merch = merchantRepo.findOne(trans.getMerchant().getId());
			List<Transactions> transactions = transactionsRepo.findByMerchantAndIssuerAndAcquirer(merch, issuer, aquirer);
			return transactions;
		}
		return null;
	}
	
	
	/////////////////////CREDITCARD METODE//////////////////////
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getCards", method = RequestMethod.GET)
	@ResponseBody
	public List<CreditCard> getAllCreditCards() {
		List<CreditCard> cards = new ArrayList<CreditCard>();
		cards = (List<CreditCard>) cardsRepo.findAll();
		return cards;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getCardBank/", method = RequestMethod.POST)
	@ResponseBody
	public List<CreditCard> getCardsByBank(@RequestBody Bank bank) {
		
		List<CreditCard> cards = cardsRepo.findByBank(bank);
		return cards;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getCardDate/", method = RequestMethod.POST)
	@ResponseBody
	public List<CreditCard> getCardsByDate (@RequestBody CreditCard card) {
		if(card.getExpirationDate() instanceof java.sql.Date){
			List<CreditCard> cards = cardsRepo.findByExpirationDate(card.getExpirationDate());
			return cards;
		}
		else{
			java.sql.Date nesto = new java.sql.Date(card.getExpirationDate().getTime());
			List<CreditCard> cards = cardsRepo.findByExpirationDate(nesto);
			return cards;
			}
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getCardDateAndBank/", method = RequestMethod.POST)
	@ResponseBody
	public List<CreditCard> getCardsByDateAndBank (@RequestBody CreditCard card) {
		if(card.getExpirationDate() instanceof java.sql.Date){
			List<CreditCard> cards = cardsRepo.findByExpirationDateAndBank(card.getExpirationDate(), card.getBank());
			return cards;
		}
		else{
			java.sql.Date nesto = new java.sql.Date(card.getExpirationDate().getTime());
			List<CreditCard> cards = cardsRepo.findByExpirationDateAndBank(nesto, card.getBank());
			return cards;
			}
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getCardCode/{code}", method = RequestMethod.POST)
	@ResponseBody
	public CreditCard getCardBySecurityCode (@PathVariable("code") int code) {
		CreditCard card = cardsRepo.findBySecurityCode(code);
		return card;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getCardCodeAndBank/", method = RequestMethod.POST)
	@ResponseBody
	public CreditCard getCardByCodeAndBank (@RequestBody CreditCard card) {
		CreditCard card1 = cardsRepo.findByBankAndSecurityCode(card.getBank(), card.getSecurityCode());
		return card1;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/saveCard/", method = RequestMethod.POST)
	@ResponseBody
	public CreditCard saveCard(@RequestBody CreditCard card) {
		
		CreditCard card1 = cardsRepo.findOne(card.getPan());
		if(card1 != null)
			return null;
		card1 = cardsRepo.save(card);
		return card1;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/updateCard/{id}", method = RequestMethod.POST)
	@ResponseBody
	public CreditCard updateCard(@PathVariable("id") long id, @RequestBody CreditCard card) {
		
		Bank bank1 = bankRepo.findOne(card.getBank().getBankID());
		CreditCard card1 = cardsRepo.findOne(id);
		if(card1 == null)
			return null;
		card1.setCardHolderName(card.getCardHolderName());
		try {
			card1.setExpirationDate(card.getExpirationDate());
		} catch (Exception e) {
			e.printStackTrace();
			//AKO SMO DOBILI java.util.Date umesto java.sql.Date
			java.sql.Date bla = new java.sql.Date(card.getExpirationDate().getTime());
			card1.setExpirationDate(bla);
		}
		if(bank1 != null)
			card1.setBank(bank1);
		card1 = cardsRepo.save(card1);
		return card1;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/deleteCard/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteCard(@PathVariable("id") long id) {
		
		CreditCard card = cardsRepo.findOne(id);
		if(card == null)
			return false;
		try {
			cardsRepo.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	///////////////////////ORDERS METODE////////////////////////
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getOrders", method = RequestMethod.GET)
	@ResponseBody
	public List<Orders> getAllOrders() {
		List<Orders> orders = new ArrayList<Orders>();
		orders = (List<Orders>) ordersRepo.findAll();
		return orders;
	}

	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/saveOrder/", method = RequestMethod.POST)
	@ResponseBody
	public Orders saveOrder(@RequestBody Orders order) {
		Orders order1 = ordersRepo.findOne(order.getOrderID());
		if (order1 != null)
			return null;
		order1 = ordersRepo.save(order);
		return order1;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/updateOrder/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Orders updateOrder(@PathVariable("id") long id, @RequestBody Orders order) {
		
		Orders order1 = ordersRepo.findOne(order.getOrderID());		
		if(order1 == null)
			return null;
		try {
			order1.setOrderTimestamp(order.getOrderTimestamp());
		} catch (Exception e) {
			e.printStackTrace();
		}
		order1.setAmount(order.getAmount());
		order1.setPaymentID(order.getPaymentID());
		order1 = ordersRepo.save(order1);
		return order1;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteOrder(@PathVariable("id") long id) {
		Orders order = ordersRepo.findOne(id);
		if(order == null)
			return false;
		try {
			ordersRepo.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getOrderAmount/{amount}", method = RequestMethod.POST)
	@ResponseBody
	public List<Orders> orderAmountLess(@PathVariable("amount") long amount) {
		List<Orders> orders = ordersRepo.findByAmountLessThanEqual(amount);
		return orders;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getOrderTimestamp/{timestamp}", method = RequestMethod.POST)
	@ResponseBody
	public Orders orderAmountLess(@PathVariable("timestamp") Timestamp timestamp) {
		Orders order = ordersRepo.findByOrderTimestamp(timestamp);
		return order;
	}
	
	@Transactional("pccTransactionManager")
	@RequestMapping(value = "/getOrderPayment/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Orders orderPayment(@PathVariable("id") long paymentId) {
		Orders order = ordersRepo.findByPaymentID(paymentId);
		return order;
	}
	
	@Autowired
	private BankRepo bankRepo;

	@Autowired
	private MerchantRepo merchantRepo;
	
	@Autowired
	private TransactionsRepo transactionsRepo;
	
	@Autowired
	private CreditCardRepo cardsRepo;
	
	@Autowired
	private OrdersRepo ordersRepo;
}
