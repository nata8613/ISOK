package datacentar.dc.isok.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.Permission;

@Repository
public interface PermissionRepo extends CrudRepository<Permission, Long>{

}
