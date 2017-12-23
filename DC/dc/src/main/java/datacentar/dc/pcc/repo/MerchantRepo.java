package datacentar.dc.pcc.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.pcc.model.Bank;
import datacentar.dc.pcc.model.Merchant;

@Repository
public interface MerchantRepo extends CrudRepository<Merchant, Long>{

	List<Merchant> findByBank(Bank bank);
	List<Merchant> findByMerchantID(String merchantID);
	List<Merchant> findByMerchantPassword(String merchantPassword);
	Merchant findByMerchantIDAndMerchantPassword(String merchantID, String merchantPassword);
}
