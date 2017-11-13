package netgloo.models.homeInsurance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "homeSurface")
public class HomeSurface {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String surfaceNum;

	public HomeSurface() {
		super();
	}


	public String getSurfaceNum() {
		return surfaceNum;
	}


	public void setSurfaceNum(String surfaceNum) {
		this.surfaceNum = surfaceNum;
	}


	public long getId() {
		return id;
	}

}
