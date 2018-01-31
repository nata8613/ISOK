package com.PCC.PCC.models;

public class Bank {

	private String name;
	private String swiftCode;
	private String bankAccountNum;
	private double accountBalance;
	private String panCode;
	private String bankPort;
	
	public Bank() {
	
	}

	public Bank(String name, String swiftCode, String bankAccountNum, double accountBalance, String panCode,
			String bankPort) {
		super();
		this.name = name;
		this.swiftCode = swiftCode;
		this.bankAccountNum = bankAccountNum;
		this.accountBalance = accountBalance;
		this.panCode = panCode;
		this.bankPort = bankPort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getBankAccountNum() {
		return bankAccountNum;
	}

	public void setBankAccountNum(String bankAccountNum) {
		this.bankAccountNum = bankAccountNum;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getPanCode() {
		return panCode;
	}

	public void setPanCode(String panCode) {
		this.panCode = panCode;
	}

	public String getBankPort() {
		return bankPort;
	}

	public void setBankPort(String bankPort) {
		this.bankPort = bankPort;
	}

	
	
	
}
