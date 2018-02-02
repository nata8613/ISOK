package com.Issuer.Issuer.repo;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Issuer.Issuer.models.Client;


@Repository
public interface ClientRepo extends CrudRepository<Client, Long>{

	Client save(Client client);
	Client findByAccountNumberAndCardHolderNameAndSecurityCodeAndValidTo(long accountNumber, String cardHolderName, int securityCode, Date validTo);
}