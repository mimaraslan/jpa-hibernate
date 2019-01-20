package com.mimaraslan.model;

import java.util.Date;

public class Customer {

	private int id;
	private String name;
	private String address;
	private Date creationDate;

	public Customer() {
	}

	public Customer(int id, String name, String address, Date creationDate) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.creationDate = creationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}