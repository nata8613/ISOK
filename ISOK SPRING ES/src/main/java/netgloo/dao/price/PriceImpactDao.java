package netgloo.dao.price;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import netgloo.models.PriceImpacts;
import netgloo.models.RiskItem;

@Transactional
public interface PriceImpactDao extends CrudRepository<PriceImpacts, Long> {
	 public List<PriceImpacts> findByRiskItemIdIn(List<Long> listRiskItemIds);
}
