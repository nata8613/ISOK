package datacentar.dc.isok.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "priceImpacts")
public class PriceImpacts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private double value;
	
	@NotNull
	private Date validFrom;
	
	@NotNull
	private Date validTo;
	
	@NotNull
	private long riskItemId;

	public PriceImpacts() {
		super();
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
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

	public long getRiskItemId() {
		return riskItemId;
	}

	public void setRiskItemId(long riskItemId) {
		this.riskItemId = riskItemId;
	}

	public long getId() {
		return id;
	}

}
