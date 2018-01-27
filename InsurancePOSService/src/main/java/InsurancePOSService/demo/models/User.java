package InsurancePOSService.demo.models;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Long id;
	 
	private String username;
	 
	private String password;
	 
	private Set<Role> allowed = new HashSet<Role>();

	public User(Long id, String username, String password, Set<InsurancePOSService.demo.models.Role> allowed) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.allowed = allowed;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<Role> getAllowed() {
		return allowed;
	}

	public void setAllowed(Set<Role> allowed) {
		this.allowed = allowed;
	}
	
	
}
