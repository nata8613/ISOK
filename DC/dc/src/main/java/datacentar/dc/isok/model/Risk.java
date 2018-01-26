package datacentar.dc.isok.model;

import static javax.persistence.CascadeType.ALL;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "risk")
public class Risk {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String riskName;

	@OneToMany(cascade={ALL}, fetch=FetchType.LAZY, mappedBy="risk")
	private Set<RiskItem> riskItems = new HashSet<RiskItem>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "risks")
	@JsonIgnore
	private Set<InsuranceCategory> categories = new HashSet<InsuranceCategory>();
	
	
	public Risk() {
		super();
	}

	public Risk(String riskName, Set<RiskItem> riskItems, Set<InsuranceCategory> categories) {
		super();
		this.riskName = riskName;
		this.riskItems = riskItems;
		this.categories = categories;
	}

	public Set<RiskItem> getRiskItems() {
		return riskItems;
	}

	public void setRiskItems(Set<RiskItem> riskItems) {
		this.riskItems = riskItems;
	}

	public Set<InsuranceCategory> getCategories() {
		return categories;
	}

	public void setCategories(Set<InsuranceCategory> categories) {
		this.categories = categories;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public long getId() {
		return id;
	}
	
}
