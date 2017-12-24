package datacentar.dc.pcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transactionsPCC")
public class Transactions {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionID;

	@NotNull
	private long paymentID; // DA LI SMO SIGURNI DA NAM OVO TREBA, I DALJE NISAM
							// POTPUNO SIGURAN IAKO GA IMA U SPECIFIKACIJI U
							// DODATKU 2 ALI JE SAMO NAVEDENO DA SE PROSLEDJUJE

	@NotNull
	private String status;

	@ManyToOne()
	@JoinColumn(name="acquirer")
	private Bank acquirer;
	
	@ManyToOne()
	@JoinColumn(name="issuer")
	private Bank issuer;
	
	@ManyToOne()
	@JoinColumn(name="merchant")
	@JsonIgnore
	private Merchant merchant;
	
	@ManyToOne()
	@JoinColumn(name="orderNum")
	private Orders orderNum;
	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(long paymentID, String status, Bank acquirer, Bank issuer, Merchant merchant,
			Orders order_num) {
		super();
		this.paymentID = paymentID;
		this.status = status;
		this.acquirer = acquirer;
		this.issuer = issuer;
		this.merchant = merchant;
		this.orderNum = order_num;
	}



	public long getTransactionID() {
		return transactionID;
	}

	public long getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(long paymentID) {
		this.paymentID = paymentID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Bank getAcquirer() {
		return acquirer;
	}


	public void setAcquirer(Bank acquirer) {
		this.acquirer = acquirer;
	}


	public Bank getIssuer() {
		return issuer;
	}


	public void setIssuer(Bank issuer) {
		this.issuer = issuer;
	}


	public Merchant getMerchant() {
		return merchant;
	}


	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}


	public Orders getOrder() {
		return orderNum;
	}


	public void setOrder(Orders order) {
		this.orderNum = order;
	}

}
