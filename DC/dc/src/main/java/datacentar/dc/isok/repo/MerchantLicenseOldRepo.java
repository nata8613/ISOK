package datacentar.dc.isok.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.MerchantLicense;

@Repository
public interface MerchantLicenseOldRepo extends CrudRepository<MerchantLicense, Long>{

}
