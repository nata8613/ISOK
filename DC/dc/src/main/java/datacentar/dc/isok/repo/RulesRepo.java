package datacentar.dc.isok.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.Rules;

@Repository
public interface RulesRepo extends CrudRepository<Rules, Long>{

}
