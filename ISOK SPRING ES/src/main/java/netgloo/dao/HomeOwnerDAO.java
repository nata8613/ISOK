package netgloo.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import netgloo.models.homeInsurance.HomeOwner;

@Transactional
public interface HomeOwnerDAO extends CrudRepository<HomeOwner, Long>{

}
