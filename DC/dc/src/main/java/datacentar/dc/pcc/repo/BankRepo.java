package datacentar.dc.pcc.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import datacentar.dc.pcc.model.Bank;


@Repository
public interface BankRepo extends CrudRepository<Bank, Long>{

	Bank findBySwiftCode(String swiftCode);
	Bank save(Bank bank);
	Bank findByCode(int code);
	Bank findByBillingAccount(String billingAccount);
	List<Bank> findByNameContaining(String name);
}
