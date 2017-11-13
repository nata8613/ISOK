package netgloo.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import netgloo.models.homeInsurance.HomeValue;

@Transactional
public interface HomeValueDAO extends CrudRepository<HomeValue, Long>{

}
