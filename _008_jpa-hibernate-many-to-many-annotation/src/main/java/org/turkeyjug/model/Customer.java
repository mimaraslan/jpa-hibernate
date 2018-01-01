package org.turkeyjug.model;

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


// 	<class name="com.keylesson.persistence.Customer" table="CUSTOMER">
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
	   <set name="addresses" table="CUST_ADDR" lazy="true" fetch="select" cascade="all">
			<key>
				<column name="CUSTOMER_ID" not-null="true" />
			</key>
			<many-to-many entity-name="com.keylesson.persistence.Address">
				<column name="ADDRESS_ID" not-null="true" />
			</many-to-many>
		</set>	
*/
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
