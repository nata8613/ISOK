package datacentar.dc.isok.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.HomeInsurance;

@Repository
public interface HomeInsuranceRepo extends CrudRepository<HomeInsurance, Long>{
	List<HomeInsurance> findByHomeOwner(String homeOWner);

}
