package netgloo.models.frontend;

public class UserDataModel {
	
	public String firstName;
	public String lastName;
	public String passportNumber;
	public String jmbg;
	public String address;
	public String mobile;
	public String email;
	public UserDataModel() {
		super();
	}
	public UserDataModel(String firstName, String lastName, String passportNumber, String jmbg, String address,
			String mobile, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.passportNumber = passportNumber;
		this.jmbg = jmbg;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
