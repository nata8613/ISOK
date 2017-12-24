package datacentar.dc.isok.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

}
