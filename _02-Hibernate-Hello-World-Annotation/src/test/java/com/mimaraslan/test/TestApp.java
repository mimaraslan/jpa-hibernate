package com.mimaraslan.test;

import java.util.Date;
import org.hibernate.Session;
import com.keylesson.util.HibernateUtil;
import com.mimaraslan.persistence.Customer;

public class TestApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Customer customer = new Customer();
			customer.setName("Aslan");
			customer.setAddress("Türkiye İstanbul");
			customer.setCreationDate(new Date());
			session.save(customer);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating Customer :" + e);
			session.getTransaction().rollback();
		}
		HibernateUtil.shutdown();
	}

}