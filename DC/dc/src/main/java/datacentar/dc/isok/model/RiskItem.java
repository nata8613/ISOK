package datacentar.dc.isok.model;

import static javax.persistence.CascadeType.ALL;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "riskItem")
public class RiskItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String itemName;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name="risk")
	@JsonIgnore
	private Risk risk;

	@OneToMany(cascade={ALL}, fetch=FetchType.LAZY, mappedBy="item")
	private Set<PriceImpacts> impacts = new HashSet<PriceImpacts>(); 
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "items")
	@JsonIgnore
	private Set<Policy> policies = new HashSet<Policy>();
	
	public RiskItem() {
		super();
	}

	public RiskItem(String itemName, Risk risk, Set<PriceImpacts> impacts, Set<Policy> policies) {
		super();
		this.itemName = itemName;
		this.risk = risk;
		this.impacts = impacts;
		this.policies = policies;
	}

	public Risk getRisk() {
		return risk;
	}

	public void setRisk(Risk risk) {
		this.risk = risk;
	}

	public Set<PriceImpacts> getImpacts() {
		return impacts;
	}

	public void setImpacts(Set<PriceImpacts> impacts) {
		this.impacts = impacts;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public long getId() {
		return id;
	}

	public Set<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(Set<Policy> policies) {
		this.policies = policies;
	}
	
	
}
