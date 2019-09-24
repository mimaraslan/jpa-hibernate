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
			
			Customer customer = new Customer("Mr.", "Mimar");
			CustomerDetail customerDetail = new CustomerDetail("Turkey Istanbul", "+212-5546-02", new Date());

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
