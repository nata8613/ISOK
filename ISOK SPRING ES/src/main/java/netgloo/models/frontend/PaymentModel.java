package netgloo.models.frontend;

public class PaymentModel {
	
	private String intent;
	private String orderID;
	private String payerID;
	private String paymentID;
	private String paymentToken;
	public PaymentModel() {
		super();
	}
	public PaymentModel(String intent, String orderID, String payerID, String paymentID, String paymentToken) {
		super();
		this.intent = intent;
		this.orderID = orderID;
		this.payerID = payerID;
		this.paymentID = paymentID;
		this.paymentToken = paymentToken;
	}
	public String getIntent() {
		return intent;
	}
	public void setIntent(String intent) {
		this.intent = intent;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getPayerID() {
		return payerID;
	}
	public void setPayerID(String payerID) {
		this.payerID = payerID;
	}
	public String getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}
	public String getPaymentToken() {
		return paymentToken;
	}
	public void setPaymentToken(String paymentToken) {
		this.paymentToken = paymentToken;
	}
	
	
}
