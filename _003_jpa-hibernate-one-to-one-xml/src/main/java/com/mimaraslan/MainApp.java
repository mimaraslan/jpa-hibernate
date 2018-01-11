package com.mimaraslan;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mimaraslan.model.Customer;
import com.mimaraslan.model.CustomerDetail;
import com.mimaraslan.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {

		Customer customer = new Customer("Mr.", "Mimar");
		CustomerDetail customerDetail = new CustomerDetail("Turkey Istanbul", "+1234-567-89", new Date());

		customer.setCustomerDetail(customerDetail);
		customerDetail.setCustomer(customer);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			System.err.println("Error creating Customer :" + e);
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}