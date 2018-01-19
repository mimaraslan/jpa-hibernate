package com.mimaraslan;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import com.mimaraslan.model.Customer;
import com.mimaraslan.model.Orders;
import com.mimaraslan.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
	
				// Create customer
				Customer customer1 = new Customer("Mr.", "Mimar");
			
				// Create orders
				Orders order1 = new Orders("code1", new Float("111.11"), new Date());
				Orders order2 = new Orders("code2", new Float("222.22"), new Date());
				Orders order3 = new Orders("code3", new Float("333.33"), new Date());
				
				// Set orders in customer1
				customer1.getOrders().add(order1);
				customer1.getOrders().add(order2);
				customer1.getOrders().add(order3);
				
				// Set customer1 in orders
				order1.setCustomer(customer1);
				order2.setCustomer(customer1);
				order3.setCustomer(customer1);
				
				// Save customer
				session.save(customer1);
				
				// Save orders
				session.save(order1);
				session.save(order2);
				session.save(order3);
				
//-------------------------------------------------------------				

				Customer customer2 = new Customer("Mr.", "Aslan");
				
				Orders order4 = new Orders("code4", new Float("444.44"), new Date());
				Orders order5 = new Orders("code5", new Float("555.55"), new Date());
				Orders order6 = new Orders("code6", new Float("666.66"), new Date());

				customer2.getOrders().add(order4);
				customer2.getOrders().add(order5);
				customer2.getOrders().add(order6);
				
				order4.setCustomer(customer2);
				order5.setCustomer(customer2);
				order6.setCustomer(customer2);
				
				session.save(customer2);

				session.save(order4);
				session.save(order5);
				session.save(order6);
					
			session.getTransaction().commit();
			
			System.out.println("-------------------------------------");
			// Read Data
			List<Customer> customers = session.createQuery("from Customer").list();
			for (Customer customer : customers) {
				Set<Orders> orders = customer.getOrders();
				
				for (Orders order : orders) {
				 System.out.println(customer.getCustomerId() + " "+customer.getTitle() + " " + customer.getName()+ ": " 
				 + order.getCode() + ", " + order.getAmount()+ ", " + order.getOrderDate()
				 + ", " + order.getOrderId()+ ", " + order.getCustomer().getCustomerId());
				}			
			}
			System.out.println("-------------------------------------");

		} catch (Exception e) {
			System.err.println("Error :" + e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
}