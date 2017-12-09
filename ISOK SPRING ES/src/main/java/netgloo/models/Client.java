package netgloo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String clientName;
	
	@NotNull
	private String clientSurname;
	
	@NotNull
	private String passportNum;
	
	@NotNull
	private String jmbg;
	
	@NotNull
	private String address;
	
	@NotNull
	private String telNum;
	
	@NotNull
	private String clientEmail;

	public Client() {
		super();
	}
	
	public Client(String clientName, String clientSurname, String passportNum, String jmbg, String address,
			String telNum, String clientEmail) {
		super();
		this.clientName = clientName;
		this.clientSurname = clientSurname;
		this.passportNum = passportNum;
		this.jmbg = jmbg;
		this.address = address;
		this.telNum = telNum;
		this.clientEmail = clientEmail;
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
	
	
}
