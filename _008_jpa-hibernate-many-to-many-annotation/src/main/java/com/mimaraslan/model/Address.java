package com.mimaraslan.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// 	<class name="com.mimaraslan.model.Address" table="ADDRESS">
@Entity
@Table(name = "ADDRESS")
public class Address {
	
/*
 	<id name="addressId" type="int">
		<column name="ADDRESS_ID" />
		<generator class="identity" />
	</id>
 */	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID", nullable = false)
	private int addressId;
		
/*
 	<property name="street" type="string">
		<column name="STREET" length="30" not-null="true" />
	</property>
 */	
	@Column(name = "STREET", nullable = false, length = 30)
	private String street;

/*
 	<property name="city" type="string">
		<column name="CITY" length="20" not-null="true" />
	</property>
 */	
	@Column(name = "CITY", nullable = false, length = 20)
	private String city;

	
/*
 	<property name="country" type="string">
		<column name="COUNTRY" length="20" not-null="true" />
	</property>
 */	
	@Column(name = "COUNTRY", nullable = false, length = 20)
	private String country;


/*
 	<property name="type" type="string">
		<column name="TYPE" length="10" />
	</property>
 */	
	@Column(name = "TYPE", length = 10)
	private String type;

	
/*
 	<set name="customers" table="CUST_ADDR" inverse="true" lazy="true" fetch="select">
		<key>
			<column name="ADDRESS_ID" not-null="true" />
		</key>
		<many-to-many entity-name="com.mimaraslan.model.Customer">
			<column name="CUSTOMER_ID" not-null="true" />
		</many-to-many>
	</set>
 */	
	@ManyToMany(mappedBy = "addresses", fetch = FetchType.LAZY)
	private Set<Customer> customers = new HashSet<Customer>(0);

	
	public Address() {
	}

	public Address(String street, String city, String country, String type) {
		this.street = street;
		this.city = city;
		this.country = country;
		this.type = type;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
}