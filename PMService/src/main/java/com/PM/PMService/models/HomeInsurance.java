package com.PM.PMService.models;

public class HomeInsurance {
private long id; 
	
	private String ownerName;
	
	private String ownerSurname;
	
	private String jmbg;

	private int insuranceLength;

	
	public HomeInsurance(String ownerName, String ownerSurname, String jmbg, int insuranceLength) {
		super();
		this.ownerName = ownerName;
		this.ownerSurname = ownerSurname;
		this.jmbg = jmbg;
		this.insuranceLength = insuranceLength;
	}

	public HomeInsurance(long id, String ownerName, String ownerSurname, String jmbg, int insuranceLength) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.ownerSurname = ownerSurname;
		this.jmbg = jmbg;
		this.insuranceLength = insuranceLength;
	}

	public HomeInsurance() {
		super();
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

	public void setId(long id) {
		this.id = id;
	}
}
