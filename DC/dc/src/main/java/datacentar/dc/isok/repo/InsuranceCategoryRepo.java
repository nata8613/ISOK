package datacentar.dc.isok.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import datacentar.dc.isok.model.InsuranceCategory;

@Repository
public interface InsuranceCategoryRepo extends CrudRepository<InsuranceCategory, Long>{
	InsuranceCategory findByCategoryName(String categoryName);

}
