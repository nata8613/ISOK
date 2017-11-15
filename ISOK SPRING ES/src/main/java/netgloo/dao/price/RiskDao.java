package netgloo.dao.price;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import netgloo.models.Risk;

@Transactional
public interface RiskDao extends CrudRepository<Risk, Long> {

}
