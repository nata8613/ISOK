package netgloo.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import netgloo.models.homeInsurance.HomeInsurance;

@Transactional
public interface HomeInsuranceDAO extends CrudRepository<HomeInsurance, Long>{

}
