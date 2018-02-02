package com.PCC.PCC.models;

import java.util.Date;

public class DataIssToAcq {

	private long acquirerOrderId;
	private Date acquirerTimestamp;
	private long issuerOrderId;
	private Date issuerTimestamp;
	private String result;
	
	public DataIssToAcq() {
		
	}

	public DataIssToAcq(long acquirerOrderId, Date acquirerTimestamp, long issuerOrderId, Date issuerTimestamp,
			String result) {
		super();
		this.acquirerOrderId = acquirerOrderId;
		this.acquirerTimestamp = acquirerTimestamp;
		this.issuerOrderId = issuerOrderId;
		this.issuerTimestamp = issuerTimestamp;
		this.result = result;
	}

	public long getAcquirerOrderId() {
		return acquirerOrderId;
	}

	public void setAcquirerOrderId(long acquirerOrderId) {
		this.acquirerOrderId = acquirerOrderId;
	}

	public Date getAcquirerTimestamp() {
		return acquirerTimestamp;
	}

	public void setAcquirerTimestamp(Date acquirerTimestamp) {
		this.acquirerTimestamp = acquirerTimestamp;
	}

	public long getIssuerOrderId() {
		return issuerOrderId;
	}

	public void setIssuerOrderId(long issuerOrderId) {
		this.issuerOrderId = issuerOrderId;
	}

	public Date getIssuerTimestamp() {
		return issuerTimestamp;
	}

	public void setIssuerTimestamp(Date issuerTimestamp) {
		this.issuerTimestamp = issuerTimestamp;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
