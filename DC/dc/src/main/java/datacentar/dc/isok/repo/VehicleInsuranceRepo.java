package datacentar.dc.isok.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.VehicleInsurance;

@Repository
public interface VehicleInsuranceRepo extends CrudRepository<VehicleInsurance, Long>{

	List<VehicleInsurance> findByRegNum(String regNum);
}
