package netgloo.models.homeInsurance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "homeAge")
public class HomeAge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String ageNum;

	public HomeAge() {
		super();
	}

	public String getAgeNum() {
		return ageNum;
	}

	public void setAgeNum(String ageNum) {
		this.ageNum = ageNum;
	}

	public long getId() {
		return id;
	}

}
