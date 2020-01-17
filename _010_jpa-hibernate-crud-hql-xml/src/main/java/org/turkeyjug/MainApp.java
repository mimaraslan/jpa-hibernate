package org.turkeyjug;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.turkeyjug.model.Product;
import org.turkeyjug.util.HibernateUtil;

public class MainApp {
	static Logger log = Logger.getLogger(MainApp.class.getName());

	public static void main(String[] args) {
		// Create 3 products
		create();

		// Read all products
		read();

		// Update second product
		update();

		// Delete third product
		delete();
		
		// Insert all product records into other_product
		insert();

		HibernateUtil.shutdown();
	}

	public static void create() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Product product1 = new Product("Book", 1, new Float(15.45), false, new Date());
			Product product2 = new Product("Pencil", 2, new Float(10.00), false, new Date());
			Product product3 = new Product("Satchel", 1, new Float(100.30), false, new Date());
			session.save(product1);
			session.save(product2);
			session.save(product3);
			t.commit();
		} catch (Exception e) {
			log.error("Error Create :", e);
			t.rollback();
		}
		session.close();
	}

	public static void read() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from Product where unitPrice < :p_unitPrice");
			query.setParameter("p_unitPrice", new Float(50.00));
			List<Product> result = query.list();
			for (Product p : result) {
				System.out.println(p.getProductName() + ", " + p.getQuantity() + ", " + p.getUnitPrice() + ", "
						+ p.getDiscontinued() + ", " + p.getModifiedDate());
			}
		} catch (Exception e) {
			log.error("Error Read :", e);
		}
		session.close();
	}

	public static void update() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query query = session.createQuery(
					"update Product set quantity=:p_quantity, discontinued=:p_discontinued where productName=:p_productName");
			query.setParameter("p_quantity", 3);
			query.setParameter("p_discontinued", true);
			query.setParameter("p_productName", "Pencil");
			int result = query.executeUpdate();
			System.out.println(result + " lines updated");
			t.commit();
		} catch (Exception e) {
			log.error("Error Update :", e);
			t.rollback();
		}
		session.close();
	}

	public static void delete() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query query = session.createQuery("delete from Product where productName=:productName");
			query.setParameter("productName", "Satchel");
			int result = query.executeUpdate();
			System.out.println(result + " lines deleted");
			t.commit();
		} catch (Exception e) {
			log.error("Error Delete :", e);
			t.rollback();
		}
		session.close();
	}


	public static void insert() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Query query = session.createQuery(
					"insert into OtherProduct (productName, quantity, modifiedDate) select p.productName, p.quantity, p.modifiedDate from Product p");
			int result = query.executeUpdate();
			System.out.println(result + " lines inserted");
			t.commit();
		} catch (Exception e) {
			log.error("Error Insert :", e);
			t.rollback();
		}
		session.close();
	}

}