package datacentar.dc.isok.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "homeInsurance")
public class HomeInsurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String ownerName;
	
	@Column(nullable = false)
	private String ownerSurname;
	
	@Column(nullable = false)
	private String jmbg;


	@Column(nullable = false)
	private int insuranceLength;

	
	public HomeInsurance() {
		super();
	}

	public HomeInsurance(String ownerName, String ownerSurname, String jmbg, int insuranceLength) {
		super();
		this.ownerName = ownerName;
		this.ownerSurname = ownerSurname;
		this.jmbg = jmbg;
		this.insuranceLength = insuranceLength;
	}


	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerSurname() {
		return ownerSurname;
	}

	public void setOwnerSurname(String ownerSurname) {
		this.ownerSurname = ownerSurname;
	}



	public String getJmbg() {
		return jmbg;
	}



	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}



	public int getInsuranceLength() {
		return insuranceLength;
	}

	public void setInsuranceLength(int insuranceLength) {
		this.insuranceLength = insuranceLength;
	}

	public long getId() {
		return id;
	}

}
