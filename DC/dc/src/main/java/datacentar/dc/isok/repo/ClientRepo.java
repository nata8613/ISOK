package datacentar.dc.isok.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.Client;

@Repository
public interface ClientRepo extends CrudRepository<Client, Long>{
	
	Client findByJmbg(String jmbg);
	Client findByPassportNum(String passportNum);
	List<Client> findByClientEmail(String clientEmail);

}
