package com.dev.frontend.model;

public class Customer {

	private String customerCode;

	private String customerName;

	private String customerAddress;

	private String customerPhone1;

	private String customerPhone2;

	private double customerCreditLimit;

	private double customerCurrentCredit;

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone1() {
		return customerPhone1;
	}

	public void setCustomerPhone1(String customerPhone1) {
		this.customerPhone1 = customerPhone1;
	}

	public String getCustomerPhone2() {
		return customerPhone2;
	}

	public void setCustomerPhone2(String customerPhone2) {
		this.customerPhone2 = customerPhone2;
	}

	public double getCustomerCreditLimit() {
		return customerCreditLimit;
	}

	public void setCustomerCreditLimit(double customerCreditLimit) {
		this.customerCreditLimit = customerCreditLimit;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public double getCustomerCurrentCredit() {
		return customerCurrentCredit;
	}

	public void setCustomerCurrentCredit(double customerCurrentCredit) {
		this.customerCurrentCredit = customerCurrentCredit;
	}

}
