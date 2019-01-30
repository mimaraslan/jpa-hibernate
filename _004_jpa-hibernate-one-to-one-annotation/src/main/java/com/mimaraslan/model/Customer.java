package com.mimaraslan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// 	<class name="com.mimaraslan.model.Customer" table="CUSTOMER">
@Entity
@Table(name = "CUSTOMER")
public class Customer {

/*
 		<id name="customerId" type="int">
			<column name="CUSTOMER_ID" />
			<generator class="identity" />
		</id>
 */	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID", nullable = false)
	private int customerId;
		
/*
 		<property name="title" type="string">
			<column name="TITLE" length="10" not-null="true" />
		</property>
 */	
	@Column(name = "TITLE", nullable = false, length = 10)
	private String title;
		
/*
 		<property name="name" type="string">
			<column name="NAME" length="20" not-null="true" />
		</property>
 */	
	@Column(name = "NAME", nullable = false, length = 20)
	private String name;
	
/*
 		<one-to-one name="customerDetail" 
					class="com.mimaraslan.model.CustomerDetail"
					cascade="save-update" />	
 */	
	@OneToOne(mappedBy="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private CustomerDetail customerDetail;

	public Customer() {
	}

	public Customer(String title, String name) {
		this.title = title;
		this.name = name;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}
}