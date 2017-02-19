package com.mimaraslan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID", nullable = false)
	private int productId;
	
	@Column(name = "PRODUCT_NAME", length = 30)	
	private String productName;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "UNIT_PRICE", precision = 10, scale = 2)
	private Float unitPrice;

	public Product() {
	}

	public Product(String productName, int quantity, Float unitPrice) {
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Product[" + productName + ", " + quantity + ", " + unitPrice + "]";
	}
}