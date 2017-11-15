package netgloo.dao.price;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import netgloo.models.InsuranceCategory;

@Transactional
public interface InsuranceCategoryDao extends CrudRepository<InsuranceCategory, Long> {
	
	  public InsuranceCategory findByCategoryName(String categoryMail);
}
