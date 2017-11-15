package netgloo.dao.price;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import netgloo.models.Pricelist;

@Transactional
public interface PricelistDao extends CrudRepository<Pricelist, Long> {

}
