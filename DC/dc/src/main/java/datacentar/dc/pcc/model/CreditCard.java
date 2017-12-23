package datacentar.dc.pcc.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "creditCard")
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pan; // POGLEDAJ DA LI JE INT OK, CITAO SAM BAS ZA SQL TO JAVA
						// MAPPING I PREPORUCUJE SE I BIGDECIMAL

	@NotNull
	private int securityCode;

	@NotNull
	private String cardHolderName;

	@NotNull
	private Date expirationDate; // CUVA U OBLIKU MM/YY, MOZDA MOZE I STRING

	@ManyToOne()
	@JoinColumn(name="bank")
	private Bank bank;
	
	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditCard(int securityCode, String cardHolderName, Date expirationDate, Bank bank) {
		super();
		this.securityCode = securityCode;
		this.cardHolderName = cardHolderName;
		this.expirationDate = expirationDate;
		this.bank = bank;
	}

	public long getPan() {
		return pan;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
