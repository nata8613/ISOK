package datacentar.dc.pcc.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name = "transactionsPCC")
public class Transactions {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionId;

	
	@Column(nullable = false)
	private long merchantOrderId;
	
	@Column(nullable = false)
	private Date merchantOrderTimestamp;
	
	@Column(nullable= true)
	private long acquirerOrderId;

	@Column(nullable= true)
	private Date acquirerOrderTimestamp;

	
	@Column(nullable= false)
	private long paymentId; 

	
	@Column(nullable = false)
	private long amount;
	
	@Column(nullable = false)
	private String status;

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Transactions(long merchantOrderId, Date merchantOrderTimestamp, long acquirerOrderId,
			Date acquirerOrderTimestamp, long paymentId, long amount, String status) {
		super();
		this.merchantOrderId = merchantOrderId;
		this.merchantOrderTimestamp = merchantOrderTimestamp;
		this.acquirerOrderId = acquirerOrderId;
		this.acquirerOrderTimestamp = acquirerOrderTimestamp;
		this.paymentId = paymentId;
		this.amount = amount;
		this.status = status;
	}


	public long getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(long merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public Date getMerchantOrderTimestamp() {
		return merchantOrderTimestamp;
	}

	public void setMerchantOrderTimestamp(Date merchantOrderTimestamp) {
		this.merchantOrderTimestamp = merchantOrderTimestamp;
	}

	public long getAcquirerOrderId() {
		return acquirerOrderId;
	}

	public void setAcquirerOrderId(long acquirerOrderId) {
		this.acquirerOrderId = acquirerOrderId;
	}

	public Date getAcquirerOrderTimestamp() {
		return acquirerOrderTimestamp;
	}

	public void setAcquirerOrderTimestamp(Date acquirerOrderTimestamp) {
		this.acquirerOrderTimestamp = acquirerOrderTimestamp;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getTransactionId() {
		return transactionId;
	}

}
