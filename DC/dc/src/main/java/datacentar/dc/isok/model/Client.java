package datacentar.dc.isok.model;

import static javax.persistence.CascadeType.ALL;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String clientName;
	
	@Column(nullable = false)
	private String clientSurname;
	
	@Column(nullable = false)
	private String jmbg;
	
	@Column(nullable = false)
	private String passportNum;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String telNum;
	
	@Column(nullable = false)
	private String clientEmail;

	@OneToMany(cascade={ALL}, fetch=FetchType.LAZY, mappedBy="insuranceOwner")
	@JsonIgnore
	private Set<Policy> policiesOwned = new HashSet<Policy>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "clients")
	@JsonIgnore
	private Set<Policy> policies = new HashSet<Policy>(); 
	
	public Client(String clientName, String clientSurname, String passportNum, String jmbg, String address,
			String telNum, String clientEmail, Set<Policy> policiesOwned, Set<Policy> policies) {
		super();
		this.clientName = clientName;
		this.clientSurname = clientSurname;
		this.passportNum = passportNum;
		this.jmbg = jmbg;
		this.address = address;
		this.telNum = telNum;
		this.clientEmail = clientEmail;
		this.policiesOwned = policiesOwned;
		this.policies = policies;
	}
	public Client() {
		super();
	}
	

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientSurname() {
		return clientSurname;
	}

	public void setClientSurname(String clientSurname) {
		this.clientSurname = clientSurname;
	}

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public long getId() {
		return id;
	}

	public Set<Policy> getPoliciesOwned() {
		return policiesOwned;
	}

	public void setPoliciesOwned(Set<Policy> policiesOwned) {
		this.policiesOwned = policiesOwned;
	}

	public Set<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(Set<Policy> policies) {
		this.policies = policies;
	}
	
	
}
