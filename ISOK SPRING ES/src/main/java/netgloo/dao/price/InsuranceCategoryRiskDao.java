package netgloo.dao.price;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import netgloo.models.InsuranceCategoryRiskID;
import netgloo.models.InsuranceCategory_Risk;

public interface InsuranceCategoryRiskDao extends CrudRepository<InsuranceCategory_Risk, InsuranceCategoryRiskID>{
	
	public List<InsuranceCategory_Risk> findByInsuranceCategoryID(Long categoryId);
}
