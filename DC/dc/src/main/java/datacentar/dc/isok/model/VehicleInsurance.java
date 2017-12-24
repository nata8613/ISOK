package datacentar.dc.isok.model;

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

	@NotNull
	private String brandAndType;
	
	@NotNull
	private String productionYear;
	
	@NotNull
	private String regNum;
	
	@NotNull
	private String chassisNum;
	
	@NotNull
	private String nameSurnameJmbg;

	public VehicleInsurance() {
		super();
	}

	public VehicleInsurance(String brandAndType, String productionYear, String regNum, String chassisNum,
			String nameSurnameJmbg) {
		super();
		this.brandAndType = brandAndType;
		this.productionYear = productionYear;
		this.regNum = regNum;
		this.chassisNum = chassisNum;
		this.nameSurnameJmbg = nameSurnameJmbg;
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

	public String getNameSurnameJmbg() {
		return nameSurnameJmbg;
	}

	public void setNameSurnameJmbg(String nameSurnameJmbg) {
		this.nameSurnameJmbg = nameSurnameJmbg;
	}

	public long getId() {
		return id;
	}
	
	
}
