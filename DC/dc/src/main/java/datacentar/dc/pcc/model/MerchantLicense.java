package datacentar.dc.pcc.model;


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
	private long merchantId;
	
	@Column(nullable = false)
	private String merchantPass;
	
		public MerchantLicense() {
		super();
		// TODO Auto-generated constructor stub
	}

		public MerchantLicense(long merchantId, String merchantPass) {
			super();
			this.merchantId = merchantId;
			this.merchantPass = merchantPass;
		}

		public long getMerchantId() {
			return merchantId;
		}

		public void setMerchantId(long merchantId) {
			this.merchantId = merchantId;
		}

		public String getMerchantPass() {
			return merchantPass;
		}

		public void setMerchantPass(String merchantPass) {
			this.merchantPass = merchantPass;
		}

		public long getId() {
			return id;
		}	
	
}
