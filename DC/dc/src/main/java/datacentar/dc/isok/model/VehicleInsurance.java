package datacentar.dc.isok.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vehicleInsurance")
public class VehicleInsurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String brandAndType;
	
	@Column(nullable = false)
	private String productionYear;
	
	@Column(nullable = false)
	private String regNum;
	
	@Column(nullable = false)
	private String chassisNum;
	
	@Column(nullable = false)
	private String ownerName;
	
	@Column(nullable = false)
	private String ownerSurname;
	
	@Column(nullable = false)
	private String jmbg;

	public VehicleInsurance() {
		super();
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

	public long getId() {
		return id;
	}
	
	
}
