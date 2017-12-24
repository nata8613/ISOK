package datacentar.dc.isok.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.Client;
import datacentar.dc.isok.model.HomeInsurance;
import datacentar.dc.isok.model.Policy;
import datacentar.dc.isok.model.TravelInsurance;

@Repository
public interface PolicyRepo extends CrudRepository<Policy, Long>{

	List<Policy> findByInsuranceOwner(Client insuranceOwner);
	Policy findByTravelInsurance(TravelInsurance travelInsurance);
	Policy findByHomeInsurance(HomeInsurance homeInsurance);
	List<Policy> findByContractStart(Date contractStart);
	List<Policy> findByContractEndLessThan(Date contractEnd);
}
