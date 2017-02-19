package com.mimaraslan;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.mimaraslan.model.Product;
import com.mimaraslan.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			
			// Add customer records in database.
			add();

			// Create criteria instance
			Criteria cr = session.createCriteria(Product.class);
			
			// Add restrictions on the criteria query
			// Get products having quantity more than 10 or name starting with Bo
			cr.add(Restrictions.or(Restrictions.gt("quantity", 10), Restrictions.ilike("productName", "Bo%")));
			
			// Using pagination : get two product records of the result
			cr.setMaxResults(2);
			
			// Using sorting : sort records in ascending order of quantity
			cr.addOrder(Order.asc("quantity"));
			
			List<Product> result = cr.list();
			
			for (Product p : result) {
				System.out.println(p.toString());
			}

			// Using projection
			Criteria crTot = session.createCriteria(Product.class);
			
			// Get the maximum of salary property.
			crTot.setProjection(Projections.max("unitPrice"));
			
			List maxPrice = crTot.list();
			System.out.println("Max Price: " + maxPrice.get(0));

		} catch (Exception e) {
			System.err.println("Error creating Customer :" + e);
		}
		HibernateUtil.shutdown();
	}

	public static void add() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.save(new Product("Book", 5, new Float(15.45)));
			session.save(new Product("Pencil", 12, new Float(10.00)));
			session.save(new Product("Satchel", 3, new Float(100.30)));
			session.save(new Product("Book2", 6, new Float(16.00)));
			session.save(new Product("Book3", 10, new Float(36.00)));
			t.commit();
		} catch (Exception e) {
			System.err.println("Error Add :" + e);
			t.rollback();
		} finally {
			session.close();
		}
	}

}