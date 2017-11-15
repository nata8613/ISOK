package netgloo.dao.price;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import netgloo.models.RiskItem;

@Transactional
public interface RiskItemDao extends CrudRepository<RiskItem, Long>{
	
	 public List<RiskItem> findByRiskIDIn(List<Long> listRiskIds);
}
