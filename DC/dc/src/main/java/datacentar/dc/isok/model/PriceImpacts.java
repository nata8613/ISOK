package datacentar.dc.isok.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "priceImpacts")
public class PriceImpacts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private double value;
	
	/*@Column(nullable = false)
	private Date validFrom;
	
	@Column(nullable = false)
	private Date validTo;
	*/
	@NotNull
	@ManyToOne()
	@JoinColumn(name="item")
	@JsonIgnore
	private RiskItem item;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "impacts")
	@JsonIgnore
	private Set<Pricelist> pricelists = new HashSet<Pricelist>();
	
	public PriceImpacts() {
		super();
	}

	
	
	public PriceImpacts(long id, double value, RiskItem item, Set<Pricelist> pricelists) {
		super();
		this.id = id;
		this.value = value;
		this.item = item;
		this.pricelists = pricelists;
	}



	public PriceImpacts(double value, RiskItem item, Set<Pricelist> pricelists) {
		super();
		this.value = value;
		this.item = item;
		this.pricelists = pricelists;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

/*	public Date getValidFrom() {
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
*/
	public long getId() {
		return id;
	}

	public RiskItem getItem() {
		return item;
	}

	public void setItem(RiskItem item) {
		this.item = item;
	}

	public Set<Pricelist> getPricelists() {
		return pricelists;
	}

	public void setPricelists(Set<Pricelist> pricelists) {
		this.pricelists = pricelists;
	}
}
