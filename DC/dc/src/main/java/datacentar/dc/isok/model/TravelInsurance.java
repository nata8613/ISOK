package datacentar.dc.isok.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "travelInsurance")
public class TravelInsurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String contactMail;
		
	@NotNull
	private int numOfPersons;
	
	@NotNull
	private double priceSum;

	public TravelInsurance() {
		super();
	}

	public String getContactMail() {
		return contactMail;
	}

	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
	}

	public int getNumOfPersons() {
		return numOfPersons;
	}

	public void setNumOfPersons(int numOfPersons) {
		this.numOfPersons = numOfPersons;
	}

	public double getPriceSum() {
		return priceSum;
	}

	public void setPriceSum(double priceSum) {
		this.priceSum = priceSum;
	}

	public long getId() {
		return id;
	}
	
	
}
