package datacentar.dc.isok.model;

import static javax.persistence.CascadeType.ALL;

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
import javax.persistence.OneToMany;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	

	@OneToMany(cascade={ALL}, fetch=FetchType.LAZY, mappedBy="user")
	@JsonIgnore
	private Set<MerchantLicense> lincenses = new HashSet<MerchantLicense>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false) },
			inverseJoinColumns = { @JoinColumn(name = "role_id",
					nullable = false) })
	private Set<Role> allowed = new HashSet<Role>();
	
	public User() {
	}


	public User(String username, String password, Set<MerchantLicense> lincenses, Set<Role> allowed) {
		super();
		this.username = username;
		this.password = password;
		this.lincenses = lincenses;
		this.allowed = allowed;
	}


	public Set<MerchantLicense> getLincenses() {
		return lincenses;
	}

	public void setLincenses(Set<MerchantLicense> lincenses) {
		this.lincenses = lincenses;
	}



	public Set<Role> getAllowed() {
		return allowed;
	}



	public void setAllowed(Set<Role> allowed) {
		this.allowed = allowed;
	}



	public Set<Role> getRoles() {
		return allowed;
	}

	public void setRoles(Set<Role> roles) {
		this.allowed = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}
}
