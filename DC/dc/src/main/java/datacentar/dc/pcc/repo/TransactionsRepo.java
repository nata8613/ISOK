package datacentar.dc.pcc.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.pcc.model.Transactions;

@Repository
public interface TransactionsRepo extends CrudRepository<Transactions, Long>{

	Transactions findByMerchantOrderId(long merchantOrderId);
	Transactions findByAcquirerOrderId(long acquirerOrderId);
	Transactions findByPaymentId(long paymentId);
	List<Transactions> findByStatus(String status);
}
