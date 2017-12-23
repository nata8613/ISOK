package datacentar.dc.pcc.model;

import static javax.persistence.CascadeType.ALL;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderID;

	@NotNull
	private long paymentID; // UMESTO BigDecimal MOZE I Number PA NE ZNAM
									// STA JE BOLJE KORISTITI

	@NotNull
	private Timestamp orderTimestamp;
	
	@NotNull
	private long amount;

	@OneToMany(cascade={ALL}, fetch=FetchType.LAZY, mappedBy="order_num")
	private Set<Transactions> transactions = new HashSet<Transactions>();
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(long paymentID, Timestamp orderTimestamp, long amount, Set<Transactions> transactions) {
		super();
		this.paymentID = paymentID;
		this.orderTimestamp = orderTimestamp;
		this.amount = amount;
		this.transactions = transactions;
	}


	public long getOrderID() {
		return orderID;
	}

	public long getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(long paymentID) {
		this.paymentID = paymentID;
	}

	public Timestamp getOrderTimestamp() {
		return orderTimestamp;
	}

	public void setOrderTimestamp(Timestamp orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Set<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transactions> transactions) {
		this.transactions = transactions;
	}

}
