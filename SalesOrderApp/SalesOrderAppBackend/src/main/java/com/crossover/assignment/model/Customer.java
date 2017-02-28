package com.crossover.assignment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "customer")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * @Id
	 * 
	 * @GeneratedValue
	 * 
	 * @Column(name = "id") private long id;
	 */

	@Id
	@Column(name = "customer_code")
	private String customerCode;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_address")
	private String customerAddress;

	@Column(name = "customer_phone1")
	private String customerPhone1;

	@Column(name = "customer_phone2")
	private String customerPhone2;

	@Column(name = "customer_credit_limit")
	private double customerCreditLimit;

	@Column(name = "customer_current_credit")
	private double customerCurrentCredit;

	/*
	 * public long getId() { return id; }
	 * 
	 * public void setId(long id) { this.id = id; }
	 */

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

	public double getCustomerCurrentCredit() {
		return customerCurrentCredit;
	}

	public void setCustomerCurrentCredit(double customerCurrentCredit) {
		this.customerCurrentCredit = customerCurrentCredit;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
