package org.turkeyjug;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.turkeyjug.model.Address;
import org.turkeyjug.model.Customer;
import org.turkeyjug.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			
			// Create 3 addresses
			Address addr1 = new Address("street1", "city1", "country1","type1");
			Address addr2 = new Address("street2", "city2", "country2","type2");
			Address addr3 = new Address("street3", "city3", "country3","type3");

			// Create 2 customers
			Set<Address> addresses1 = new HashSet<Address>(0);
			addresses1.addAll(Arrays.asList(addr1, addr3));
			Customer cust1 = new Customer("Mr", "Mimar", addresses1);

			Set<Address> addresses2 = new HashSet<Address>(0);
			addresses2.addAll(Arrays.asList(addr2, addr3));
			Customer cust2 = new Customer("Mrs.", "Katerina", addresses2);

			// Save customers
			session.save(cust1);
			session.save(cust2);

			session.getTransaction().commit();

			System.out.println("-------------------------------------");
			// Read Data
			List<Customer> customers = session.createQuery("from Customer").list();
			for (Customer customer : customers) {
				Set<Address> addresses = customer.getAddresses();
				
				for (Address address : addresses) {
				 System.out.println(customer.getTitle() + " " + customer.getName()+ ": " 
				 + address.getStreet() + ", " + address.getCity()+ ", " + address.getCountry());
				}
				
			}
			System.out.println("-------------------------------------");

		} catch (Exception e) {
			System.err.println("Error :" + e);
			session.getTransaction().rollback();
		}
		HibernateUtil.shutdown();
	}

}