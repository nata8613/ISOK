package datacentar.dc.isok.repo;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import datacentar.dc.isok.model.HomeAge;

@Transactional
public interface HomeAgeRepo extends CrudRepository<HomeAge, Long>{

}
