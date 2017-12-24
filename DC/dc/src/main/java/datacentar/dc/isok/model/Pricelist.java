package datacentar.dc.isok.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "priceList")
public class Pricelist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private Date validFrom;
	
	@NotNull
	private Date validTo;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "priceImpact_pricelist", joinColumns = {
			@JoinColumn(name = "priceImpact_id", nullable = false) },
			inverseJoinColumns = { @JoinColumn(name = "pricelist_id",
					nullable = true) })
	private Set<PriceImpacts> impacts = new HashSet<PriceImpacts>();

	public Pricelist() {
		super();
	}

	public Pricelist(Date validFrom, Date validTo, Set<PriceImpacts> impacts) {
		super();
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.impacts = impacts;
	}


	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public long getId() {
		return id;
	}


	public Set<PriceImpacts> getImpacts() {
		return impacts;
	}


	public void setImpacts(Set<PriceImpacts> impacts) {
		this.impacts = impacts;
	}
	
}
