package com.Issuer.Issuer.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Issuer.Issuer.models.Transaction;

@Repository
public interface TransactionRepo extends CrudRepository<Transaction, Long>{

//	Transaction saveTransaction(Transaction transaction);
	Transaction findByIssuerId(long issuerId);
}