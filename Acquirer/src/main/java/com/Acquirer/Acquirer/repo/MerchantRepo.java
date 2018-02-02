package com.Acquirer.Acquirer.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Acquirer.Acquirer.models.Merchant;


@Repository
public interface MerchantRepo extends CrudRepository<Merchant, Long>{
	Merchant findByMerchantIdAndMerchantPassword(String merchantId, String merchantPassword);
	Merchant findByAccountNumber(long accountNumber);
}
