package datacentar.dc.isok.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rules {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String rule;

	public Rules() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rules(String rule) {
		super();
		this.rule = rule;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public long getId() {
		return id;
	}
	
	
}
