package InsurancePOSService.demo.models;

public class TravelInsurance {

	private int duration;
	private String region;
	private int numberOfPeople;
	private String ages;
	private String sport;
	private String ammount;
	
	public TravelInsurance() {
		super();
	}
	public TravelInsurance(int duration, String region, int numberOfPeople, String ages, String sport, String ammount) {
		super();
		this.duration = duration;
		this.region = region;
		this.numberOfPeople = numberOfPeople;
		this.ages = ages;
		this.sport = sport;
		this.ammount = ammount;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public String getAges() {
		return ages;
	}
	public void setAges(String ages) {
		this.ages = ages;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getAmmount() {
		return ammount;
	}
	public void setAmmount(String ammount) {
		this.ammount = ammount;
	}
	
	
	
}
