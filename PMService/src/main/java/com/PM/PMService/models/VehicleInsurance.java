package com.PM.PMService.models;

public class VehicleInsurance {
private long id;
	
	private String brandAndType;
	
	
	private String productionYear;
	
	
	private String regNum;
	
	
	private String chassisNum;
	
	private String ownerName;
	
	private String ownerSurname;
	
	private String jmbg;

	public VehicleInsurance(long id, String brandAndType, String productionYear, String regNum, String chassisNum,
			String ownerName, String ownerSurname, String jmbg) {
		super();
		this.id = id;
		this.brandAndType = brandAndType;
		this.productionYear = productionYear;
		this.regNum = regNum;
		this.chassisNum = chassisNum;
		this.ownerName = ownerName;
		this.ownerSurname = ownerSurname;
		this.jmbg = jmbg;
	}
	

	public VehicleInsurance(String brandAndType, String productionYear, String regNum, String chassisNum,
			String ownerName, String ownerSurname, String jmbg) {
		super();
		this.brandAndType = brandAndType;
		this.productionYear = productionYear;
		this.regNum = regNum;
		this.chassisNum = chassisNum;
		this.ownerName = ownerName;
		this.ownerSurname = ownerSurname;
		this.jmbg = jmbg;
	}


	public VehicleInsurance() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrandAndType() {
		return brandAndType;
	}

	public void setBrandAndType(String brandAndType) {
		this.brandAndType = brandAndType;
	}

	public String getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getChassisNum() {
		return chassisNum;
	}

	public void setChassisNum(String chassisNum) {
		this.chassisNum = chassisNum;
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


	
}
