package com.mimaraslan;

import java.util.Date;

import org.hibernate.Session;

import com.mimaraslan.model.Customer;
import com.mimaraslan.model.CustomerDetail;
import com.mimaraslan.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			
			session.beginTransaction();
			
			// Create detail customer
			CustomerDetail customerDetail = new CustomerDetail("188 Istanbul Turkey", "+123-45676789", new Date());
			
			// Create customer
			Customer customer = new Customer("Mr.", "Aslan");
			
			// Set detail in customer
			customer.setCustomerDetail(customerDetail);
			
			// Set customer in detail
			customerDetail.setCustomer(customer);
			
			// Save
			session.save(customer);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.err.println("Error :" + e);
			session.getTransaction().rollback();
		}
		HibernateUtil.shutdown();
	}
}