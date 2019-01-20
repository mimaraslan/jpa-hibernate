package com.mimaraslan;

import java.util.Date;
import org.hibernate.Session;

import com.mimaraslan.model.Customer;
import com.mimaraslan.util.HibernateUtil;

public class MainApp {

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