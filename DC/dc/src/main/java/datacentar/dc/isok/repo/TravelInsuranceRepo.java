package datacentar.dc.isok.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.TravelInsurance;

@Repository
public interface TravelInsuranceRepo extends CrudRepository<TravelInsurance, Long>{

	List<TravelInsurance> findByContactMail (String contactMail);
}
