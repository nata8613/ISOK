package netgloo.models;

public class TravelInsurance {

	private long id; 
	
	private String contactMail;
		 
	private int numOfPersons;
	 
	private double priceSum;

	public TravelInsurance(long id, String contactMail, int numOfPersons, double priceSum) {
		super();
		this.id = id;
		this.contactMail = contactMail;
		this.numOfPersons = numOfPersons;
		this.priceSum = priceSum;
	}
	public TravelInsurance(String contactMail, int numOfPersons, double priceSum) {
		super();
		this.contactMail = contactMail;
		this.numOfPersons = numOfPersons;
		this.priceSum = priceSum;
	}

	public TravelInsurance() {
		super();
	}

	public String getContactMail() {
		return contactMail;
	}

	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
	}

	public int getNumOfPersons() {
		return numOfPersons;
	}

	public void setNumOfPersons(int numOfPersons) {
		this.numOfPersons = numOfPersons;
	}

	public double getPriceSum() {
		return priceSum;
	}

	public void setPriceSum(double priceSum) {
		this.priceSum = priceSum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}
