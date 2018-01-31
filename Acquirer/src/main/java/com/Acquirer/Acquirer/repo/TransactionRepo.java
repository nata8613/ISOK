package com.Acquirer.Acquirer.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Acquirer.Acquirer.models.Transaction;


@Repository
public interface TransactionRepo extends CrudRepository<Transaction, Long>{

//	Transaction saveTransaction(Transaction transaction);
	Transaction findByPaymentID(long paymentID);
}
