package com.PM.PMService.models;



public class Rules {

	private long id;
	
	private String rule;

	public Rules() {
		super();
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
