package datacentar.dc.pcc.model;

import static javax.persistence.CascadeType.ALL;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "merchant")
public class Merchant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String merchantID;

	@NotNull
	private String merchantPassword;

	@ManyToOne()
	@JoinColumn(name="bank")
	@JsonIgnore
	private Bank bank;
	
	@OneToMany(cascade={ALL}, fetch=FetchType.LAZY, mappedBy="merchant")
	@JsonIgnore
	private Set<Transactions> transactions = new HashSet<Transactions>();
	
	public Merchant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Merchant(String merchantID, String merchantPassword, Bank bank, Set<Transactions> transactions) {
		super();
		this.merchantID = merchantID;
		this.merchantPassword = merchantPassword;
		this.bank = bank;
		this.transactions = transactions;
	}


	public long getId() {
		return id;
	}

	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public String getMerchantPassword() {
		return merchantPassword;
	}

	public void setMerchantPassword(String merchantPassword) {
		this.merchantPassword = merchantPassword;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Set<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transactions> transactions) {
		this.transactions = transactions;
	}

}
