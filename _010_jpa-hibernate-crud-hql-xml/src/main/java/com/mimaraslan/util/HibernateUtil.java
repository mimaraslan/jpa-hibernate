package com.mimaraslan.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	static Logger log = Logger.getLogger(HibernateUtil.class.getName());
	private static ServiceRegistry serviceRegistry;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Error creating SessionFactory :" + ex);
			log.error("Error creating SessionFactory :", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}
}