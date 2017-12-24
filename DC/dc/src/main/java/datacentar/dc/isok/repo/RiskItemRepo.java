package datacentar.dc.isok.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.Risk;
import datacentar.dc.isok.model.RiskItem;

@Repository
public interface RiskItemRepo extends CrudRepository<RiskItem, Long>{

	List<RiskItem> findByRisk(Risk risk);
}
