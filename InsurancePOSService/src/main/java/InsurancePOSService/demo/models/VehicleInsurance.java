package InsurancePOSService.demo.models;

public class VehicleInsurance {
 
	private long id;
	
	private String brandAndType;
	
	
	private String productionYear;
	
	
	private String regNum;
	
	
	private String chassisNum;
	
	
	private String nameSurnameJmbg;


	public VehicleInsurance( long id, String brandAndType, String productionYear, String regNum, String chassisNum,
			String nameSurnameJmbg) {
		super();
		this.id = id;
		this.brandAndType = brandAndType;
		this.productionYear = productionYear;
		this.regNum = regNum;
		this.chassisNum = chassisNum;
		this.nameSurnameJmbg = nameSurnameJmbg;
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
	
	public VehicleInsurance() {
		super();
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


	public void setId(long id) {
		this.id = id;
	}
	
	
}
