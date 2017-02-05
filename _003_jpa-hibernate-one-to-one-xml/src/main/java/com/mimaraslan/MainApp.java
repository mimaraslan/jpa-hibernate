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
			
			Customer customer = new Customer("Mr.", "Mimar");
			CustomerDetail customerDetail = new CustomerDetail("Turkey Istanbul", "+1234-567-89", new Date());

			customer.setCustomerDetail(customerDetail);
			customerDetail.setCustomer(customer);
			
			session.save(customer);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error :" + e);
			session.getTransaction().rollback();
		}
		HibernateUtil.shutdown();
	}
}