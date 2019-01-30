package com.mimaraslan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
 	<set name="orders" table="ORDERS" inverse="true" lazy="true" fetch="select">
		<key>
			<column name="CUSTOMER_ID" not-null="true" />
		</key>
		<one-to-many class="com.mimaraslan.model.Orders" />
	</set>
 */
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	private Set<Orders> orders = new HashSet<Orders>(0);


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

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
}