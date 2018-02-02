package netgloo.models;
import java.util.HashSet;
import java.util.Set;


public class Client {

	private long id;
	
	private String clientName;
	
	
	private String clientSurname;
	
	
	private String passportNum;
	
	
	private String jmbg;
	
	
	private String address;
	
	
	private String telNum;
	
	
	private String clientEmail;

	public Client(long id, String clientName, String clientSurname, String passportNum, String jmbg, String address,
			String telNum, String clientEmail, Set<Policy> policiesOwned, Set<Policy> policies) {
		super();
		this.id = id;
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
	
	public Client(){}
	
	private Set<Policy> policiesOwned = new HashSet<Policy>();

	private Set<Policy> policies = new HashSet<Policy>();

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	} 
	
	
}
