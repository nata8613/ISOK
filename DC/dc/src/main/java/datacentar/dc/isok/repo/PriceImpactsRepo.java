package datacentar.dc.isok.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.PriceImpacts;
import datacentar.dc.isok.model.RiskItem;

@Repository
public interface PriceImpactsRepo extends CrudRepository<PriceImpacts, Long>{

	PriceImpacts findByItem(RiskItem item);
	//List<PriceImpacts> findByValidTo(Date validTo);
	//List<PriceImpacts> findByValidFrom(Date validFrom);
}
