package netgloo.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import netgloo.models.homeInsurance.HomeAge;

@Transactional
public interface HomeAgeDAO extends CrudRepository<HomeAge, Long>{

}
