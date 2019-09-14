package org.turkeyjug;

import java.util.Date;
import org.hibernate.Session;
import org.turkeyjug.model.Customer;
import org.turkeyjug.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Customer customer = new Customer();
			customer.setName("Mimar");
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
