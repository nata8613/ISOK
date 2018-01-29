package datacentar.dc.isok.repo;

import datacentar.dc.isok.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long>{

	Role findByNaziv(String naziv);
}
