package datacentar.dc.pcc.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import datacentar.dc.pcc.model.Bank;
import datacentar.dc.pcc.model.Merchant;
import datacentar.dc.pcc.model.Orders;
import datacentar.dc.pcc.model.Transactions;

public interface TransactionsRepo extends CrudRepository<Transactions, Long>{

	List<Transactions> findByAcquirer(Bank acquirer);
	List<Transactions> findByIssuer(Bank Issuer);
	List<Transactions> findByAcquirerAndIssuer(Bank acquirer, Bank Issuer);
	Transactions findByOrder(Orders order);
	List<Transactions> findByMerchant(Merchant merchant);
	List<Transactions> findByMerchantAndAcquirer(Merchant merchant, Bank acquirer);
	List<Transactions> findByMerchantAndIssuer(Merchant merchant, Bank Issuer);
	List<Transactions> findByMerchantAndIssuerAndAcquirer(Merchant merchant, Bank Issuer, Bank acquirer);
}
