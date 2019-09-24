package org.turkeyjug;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.turkeyjug.dao.CustomerDAO;
import org.turkeyjug.model.Customer;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("applicationContext-hibernate.xml");
			CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");

			// Add customers
			customerDAO.add("Walid", "222 RUE LARACHE", new Date());
			customerDAO.add("Mariam", "111 RUE MARRAKECH", new Date());

			// List customers
			List<Customer> result = customerDAO.list();
			for (Customer cust : result) {
				System.out.println(cust.toString());
			}
		} catch (Exception e) {
			System.err.println("Error creating Customer :" + e);
		} finally {
			context.close();
		}
	}

}