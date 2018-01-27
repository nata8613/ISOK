package InsurancePOSService.demo.models;

import java.util.HashSet;
import java.util.Set;

public class InsuranceCategory {

	private long id;
	
	private String categoryName;

	private Set<Risk> risks = new HashSet<Risk>();

	public InsuranceCategory(long id, String categoryName, Set<Risk> risks) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.risks = risks;
	}

	public InsuranceCategory() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Risk> getRisks() {
		return risks;
	}

	public void setRisks(Set<Risk> risks) {
		this.risks = risks;
	}
	
	
}
