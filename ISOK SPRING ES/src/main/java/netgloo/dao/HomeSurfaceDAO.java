package netgloo.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import netgloo.models.homeInsurance.HomeSurface;

@Transactional
public interface HomeSurfaceDAO extends CrudRepository<HomeSurface, Long>{

}
