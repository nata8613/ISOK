package datacentar.dc.pcc.model;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bank")
public class Bank implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bankID;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int code;

	@Column(nullable = false)
	private String swiftCode;

	@Column(nullable = false)
	private String billingAccount;
	
	@OneToMany(cascade={ALL}, fetch=FetchType.EAGER, mappedBy="bank")
	private Set<Merchant> merchants = new HashSet<Merchant>();

	@OneToMany(cascade={ALL}, fetch=FetchType.LAZY, mappedBy="bank")
	@JsonIgnore
	private Set<CreditCard> cards = new HashSet<CreditCard>();
	
	@OneToMany(cascade={ALL}, fetch=FetchType.LAZY, mappedBy="acquirer")
	@JsonIgnore
	private Set<Transactions> acTrans = new HashSet<Transactions>();
	
	@OneToMany(cascade={ALL}, fetch=FetchType.LAZY, mappedBy="issuer")
	@JsonIgnore
	private Set<Transactions> issTrans = new HashSet<Transactions>();
	
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bank(String name, int code, String swiftCode, String billingAccount, Set<Merchant> merchants,
			Set<CreditCard> cards, Set<Transactions> acTrans, Set<Transactions> issTrans) {
		super();
		this.name = name;
		this.code = code;
		this.swiftCode = swiftCode;
		this.billingAccount = billingAccount;
		this.merchants = merchants;
		this.cards = cards;
		this.acTrans = acTrans;
		this.issTrans = issTrans;
	}


	public long getBankID() {
		return bankID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getBillingAccount() {
		return billingAccount;
	}

	public void setBillingAccount(String billingAccount) {
		this.billingAccount = billingAccount;
	}

	public Set<Merchant> getMerchants() {
		return merchants;
	}

	public void setMerchants(Set<Merchant> merchants) {
		this.merchants = merchants;
	}
	
	public void addMerchants(Merchant merchant){
		this.merchants.add(merchant);
		if(merchant.getBank()== null || merchant.getBank().getBankID()!= this.getBankID())
			merchant.setBank(this);
	}

	public Set<CreditCard> getCards() {
		return cards;
	}

	public void setCards(Set<CreditCard> cards) {
		this.cards = cards;
	}
	
	public void addCard(CreditCard card){
		this.cards.add(card);
		if(card.getBank()== null || card.getBank().getBankID() != this.bankID)
			card.setBank(this);
	}

	public Set<Transactions> getAcTrans() {
		return acTrans;
	}

	public void setAcTrans(Set<Transactions> acTrans) {
		this.acTrans = acTrans;
	}

	public Set<Transactions> getIssTrans() {
		return issTrans;
	}

	public void setIssTrans(Set<Transactions> issTrans) {
		this.issTrans = issTrans;
	}

}
