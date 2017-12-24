package datacentar.dc.isok.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "role_permission", joinColumns = {
			@JoinColumn(name = "role_id", nullable = false) },
			inverseJoinColumns = { @JoinColumn(name = "permission_id",
					nullable = false) })
	private Set<Permission> permissions = new HashSet<Permission>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "allowed")
	@JsonIgnore
	private Set<User> users = new HashSet<User>();
	
	public Role() {
	}
	
	public Role(String naziv) {
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

	
	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
