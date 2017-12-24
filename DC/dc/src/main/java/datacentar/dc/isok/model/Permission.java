package datacentar.dc.isok.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Permission implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String naziv;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "permissions")
	@JsonIgnore
	private Set<Role> roles = new HashSet<Role>();
	
	public Permission() {
	}

	public Permission(String naziv) {
		super();
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Long getId() {
		return id;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
