package org.turkeyjug.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

//	<class name="com.mimaraslan.persistence.CustomerDetail" table="CUSTOMER_DETAIL">
@Entity
@Table(name = "CUSTOMER_DETAIL")
public class CustomerDetail {

/*
 		<id name="customerId" type="int">
			<column name="CUSTOMER_ID" />
			<generator class="foreign">
				<param name="property">customer</param>
			</generator>
		</id>
 */	
	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "foreign", 
					  parameters = @Parameter(name = "property", value = "customer"))
	@Column(name = "CUSTOMER_ID", nullable = false)
	private int customerId;

	
/*
 		<property name="address" type="string">
			<column name="ADDRESS" length="50" default="NULL" />
		</property>
 */	
	@Column(name = "ADDRESS", length = 50)
	private String address;

/*
 		<property name="tel" type="string">
			<column name="TEL" length="20" default="NULL" />
		</property>
 */	
	@Column(name = "TEL", length = 20)
	private String tel;

/*
 		<property name="creationDate" type="date">
			<column name="CREATION_DATE" length="10" />
		</property>
 */	
	@Column(name = "CREATION_DATE", length = 10)
	private Date creationDate;

/*
 		<one-to-one name="customer" 
					class="com.mimaraslan.persistence.Customer"
					constrained="true" />
 */	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Customer customer;

	public CustomerDetail() {
	}

	public CustomerDetail(String address, String tel, Date creationDate) {
		this.address = address;
		this.tel = tel;
		this.creationDate = creationDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
