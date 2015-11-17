package com.crossover.assignment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "product")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3370192605547038070L;

	/*
	 * @Id
	 * 
	 * @GeneratedValue
	 * 
	 * @Column(name = "id") private int id;
	 */

	@Id
	@Column(name = "product_code")
	private String productCode;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "product_price")
	private double productPrice;

	@Column(name = "product_quantity")
	private int productQuantity;

	/*
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 */

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

}
