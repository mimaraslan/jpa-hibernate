package org.turkeyjug.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

// 	<class name="com.keylesson.persistence.Orders" table="ORDERS">
@Entity
@Table(name = "ORDERS")
public class Orders {

/*
	<id name="orderId" type="int">
		<column name="ORDER_ID" />
		<generator class="identity" />
	</id>
*/	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID", nullable = false)
	private int orderId;


/*
	<property name="code" type="string">
		<column name="CODE" length="20" not-null="true" unique="true" />
	</property>
*/
	@Column(name = "CODE", nullable = false, unique = true, length = 20)
	private String code;

	
/*
 	<property name="amount" type="java.lang.Float">
		<column name="AMOUNT" precision="10" scale="2" />
	</property>
 */	
	@Column(name = "AMOUNT", precision = 10, scale = 2)
	private Float amount;

	
/*
 	<property name="orderDate" type="date">
		<column name="ORDER_DATE" length="10" />
	</property>
 */	
	@Column(name = "ORDER_DATE", length = 10)
	private Date orderDate;

	
/*
 	<many-to-one name="customer" class="com.keylesson.persistence.Customer"	fetch="select">
		<column name="CUSTOMER_ID" not-null="true" />
	</many-to-one>
 */	
	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)//It makes reference to orders,
	private Customer customer;

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
