package datacentar.dc.isok.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class MerchantLicense {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String merchantId;
	
	@Column(nullable = false)
	private String bank;
	
	
	@ManyToOne()
	@JoinColumn(name="user")
	private User user;

	public MerchantLicense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MerchantLicense(String merchantId, String bank, User user) {
		super();
		this.merchantId = merchantId;
		this.bank = bank;
		this.user = user;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}
	
	
}
