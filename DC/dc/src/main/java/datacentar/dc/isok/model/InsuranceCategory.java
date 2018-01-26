package datacentar.dc.isok.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "insuranceCategory")
public class InsuranceCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String categoryName;
	
	@Column(nullable = false)
	private double startingPrice;
	
	@Column(nullable = false)
	private double clientFee;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "category_risk", joinColumns = {
			@JoinColumn(name = "category_id", nullable = false) },
			inverseJoinColumns = { @JoinColumn(name = "risk_id",
					nullable = false) })
	private Set<Risk> risks = new HashSet<Risk>();
	
	public InsuranceCategory() {
		super();
	}


	public InsuranceCategory(String categoryName, double startingPrice, double clientFee, Set<Risk> risks) {
		super();
		this.categoryName = categoryName;
		this.startingPrice = startingPrice;
		this.clientFee = clientFee;
		this.risks = risks;
	}

	public Set<Risk> getRisks() {
		return risks;
	}

	public void setRisks(Set<Risk> risks) {
		this.risks = risks;
	}

	public InsuranceCategory(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public long getId() {
		return id;
	}

	public double getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(double startingPrice) {
		this.startingPrice = startingPrice;
	}


	public double getClientFee() {
		return clientFee;
	}


	public void setClientFee(double clientFee) {
		this.clientFee = clientFee;
	}
	
}
