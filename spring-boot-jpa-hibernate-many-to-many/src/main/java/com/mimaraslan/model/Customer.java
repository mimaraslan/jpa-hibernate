package com.mimaraslan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID", nullable = false)
	private int customerId;

	@Column(name = "TITLE", nullable = false, length = 10)
	private String title;

	@Column(name = "NAME", nullable = false, length = 20)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "CUST_ADDR", 
			   joinColumns = { @JoinColumn(name = "CUSTOMER_ID", nullable = false) }, 
			   inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID", nullable = false) }
	)
	private Set<Address> addresses = new HashSet<Address>(0);

	public Customer() {
	}

	public Customer(String title, String name, Set<Address> addresses) {
		this.title = title;
		this.name = name;
		this.addresses = addresses;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
}