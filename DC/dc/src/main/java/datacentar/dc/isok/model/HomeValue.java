package datacentar.dc.isok.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "home_value")
public class HomeValue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String approxValue;

	public HomeValue() {
		super();
	}

	public String getApproxValue() {
		return approxValue;
	}

	public void setApproxValue(String approxValue) {
		this.approxValue = approxValue;
	}

	public long getId() {
		return id;
	}

}
