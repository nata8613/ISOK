package netgloo.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import netgloo.models.homeInsurance.InsuranceType;

@Transactional
public interface InsuranceTypeDAO extends CrudRepository<InsuranceType, Long>{

}
