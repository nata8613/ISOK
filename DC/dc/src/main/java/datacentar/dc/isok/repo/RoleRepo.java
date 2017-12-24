package datacentar.dc.isok.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long>{

}
