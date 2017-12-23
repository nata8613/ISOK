package datacentar.dc.pcc.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.pcc.model.Bank;
import datacentar.dc.pcc.model.CreditCard;

@Repository
public interface CreditCardRepo extends CrudRepository<CreditCard, Long>{

	List<CreditCard> findByBank(Bank bank);
	List<CreditCard> findByExpirationDate(Date expirationDate);
	List<CreditCard> findByExpirationDateAndBank(Date expirationDate, Bank bank);
	CreditCard findByBankAndSecurityCode (Bank bank, int securityCode);
	CreditCard findBySecurityCode (int securityCode);
}
