package datacentar.dc.pcc.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.pcc.model.MerchantLicense;

@Repository
public interface MerchantLicenseRepo extends CrudRepository<MerchantLicense, Long>{

}
