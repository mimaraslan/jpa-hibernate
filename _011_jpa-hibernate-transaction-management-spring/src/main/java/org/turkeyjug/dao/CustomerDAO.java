package org.turkeyjug.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.turkeyjug.model.Customer;

@Repository
@Transactional(value = "keyTransactionManager")
public class CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(String name, String address, Date date) throws HibernateException {
		Customer cust = new Customer(name, address, date);
		sessionFactory.getCurrentSession().save(cust);
	}

	public List<Customer> list() throws HibernateException {
		return sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}

}