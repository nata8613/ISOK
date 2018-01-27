package InsurancePOSService.demo.models;

public class RiskItemDTO {

	private String id;

	private String name;
	
	public RiskItemDTO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public RiskItemDTO(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
