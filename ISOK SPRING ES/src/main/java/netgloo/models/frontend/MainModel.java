package netgloo.models.frontend;

public class MainModel {
	
	public String dateStart;
	public String dateEnd; 
	public String numOfPersonsLess; 
	public String numOfPersonsMore; 
	public String state; 
	public String priceRange; 
	public String sport; 
	public String email; 
	public String totalPrice;
	public MainModel(String dateStart, String dateEnd, String numOfPersonsLess, String numOfPersonsMore, String state,
			String priceRange, String sport, String email, String totalPrice) {
		super();
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.numOfPersonsLess = numOfPersonsLess;
		this.numOfPersonsMore = numOfPersonsMore;
		this.state = state;
		this.priceRange = priceRange;
		this.sport = sport;
		this.email = email;
		this.totalPrice = totalPrice;
	}
	public MainModel() {
		super();
	}
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public String getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getNumOfPersonsLess() {
		return numOfPersonsLess;
	}
	public void setNumOfPersonsLess(String numOfPersonsLess) {
		this.numOfPersonsLess = numOfPersonsLess;
	}
	public String getNumOfPersonsMore() {
		return numOfPersonsMore;
	}
	public void setNumOfPersonsMore(String numOfPersonsMore) {
		this.numOfPersonsMore = numOfPersonsMore;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	} 
	
	
}
