package com.mimaraslan.model;

import java.util.Date;

public class Orders {

	private int orderId;
	private String code;
	private Float amount;
	private Date orderDate;
	private Customer customer;
	/*
	   <many-to-one name="customer" class="com.mimaraslan.model.Customer" fetch="select">
			<column name="CUSTOMER_ID" not-null="true" />
		</many-to-one>
	 */
	
	public Orders() {
	}

	public Orders(String code, Float amount, Date orderDate) {
		this.code = code;
		this.amount = amount;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}