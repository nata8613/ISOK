package datacentar.dc.isok.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.PriceImpacts;
import datacentar.dc.isok.model.Pricelist;

@Repository
public interface PricelistRepo extends CrudRepository<Pricelist, Long>{

	List<Pricelist> findByValidTo(Date validTo);
	List<Pricelist> findByValidFromGreaterThanAndValidToLessThanOrderByValidFromDesc(Date validTo, Date validFrom);

}
