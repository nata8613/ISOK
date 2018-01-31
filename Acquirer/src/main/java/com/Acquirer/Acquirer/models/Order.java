package com.Acquirer.Acquirer.models;

import java.util.Date;

public class Order {

	private double amount;
	private long orderId;
	private Date timestamp;
	public Order() {
		
	}
	public Order(double amount, long orderId, Date timestamp) {
		super();
		this.amount = amount;
		this.orderId = orderId;
		this.timestamp = timestamp;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
