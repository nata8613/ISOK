package com.PM.PMService.models;

import java.util.HashSet;
import java.util.Set;

public class Permission {

	private Long id;
	
	private String naziv;
	
	private Set<Role> roles = new HashSet<Role>();

	public Permission(Long id, String naziv, Set<Role> roles) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.roles = roles;
	}

	public Permission() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
