package com.Acquirer.Acquirer.repo;



import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Acquirer.Acquirer.models.Client;

@Repository
public interface ClientRepo extends CrudRepository<Client, Long>{

	//Client save(Client client);
	Client findByAccountNumberAndCardHolderNameAndSecurityCodeAndValidTo(long pan, String cardHolderName,
			int secuityCode, Date validDate);

}
