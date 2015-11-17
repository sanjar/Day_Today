package com.dev.frontend.model;

public class Customer {

	private long id;

	private String customerCode;

	private String customerName;

	private String customerPhone;

	private String customerCurrentCredit;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerCurrentCredit() {
		return customerCurrentCredit;
	}

	public void setCustomerCurrentCredit(String customerCurrentCredit) {
		this.customerCurrentCredit = customerCurrentCredit;
	}

}
