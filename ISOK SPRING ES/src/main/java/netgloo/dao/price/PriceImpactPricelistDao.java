package netgloo.dao.price;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import netgloo.models.PriceImpactPricelistID;
import netgloo.models.PriceImpact_Pricelist;

@Transactional
public interface PriceImpactPricelistDao extends CrudRepository<PriceImpact_Pricelist, PriceImpactPricelistID> {

}
