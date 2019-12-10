package org.turkeyjug;

import java.util.Date;

import org.hibernate.Session;
import org.turkeyjug.model.Customer;
import org.turkeyjug.model.CustomerDetail;
import org.turkeyjug.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			
			session.beginTransaction();
			// Create detail customer
			CustomerDetail customerDetail = new CustomerDetail("34 KADIKOY ISTANBUL", "+216-123-45-67", new Date());
			
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
