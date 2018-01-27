package InsurancePOSService.demo.models;

import java.util.HashSet;
import java.util.Set;

public class Role {

	private Long id;
	 
	private String naziv;
	 
	private Set<Permission> permissions = new HashSet<Permission>();
	 
	private Set<User> users = new HashSet<User>();

	public Role(Long id, String naziv, Set<InsurancePOSService.demo.models.Permission> permissions,
			Set<InsurancePOSService.demo.models.User> users) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.permissions = permissions;
		this.users = users;
	}

	public Role() {
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
