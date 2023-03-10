package com.mimaraslan;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mimaraslan.model.Customer;
import com.mimaraslan.util.HibernateUtil;

public class AppMain {

    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setFirstname("Mimar");
        customer.setLastname("Aslan");
        customer.setAddress("Türkiye İstanbul");
        customer.setCreationDate(new Date());

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
        } catch (HibernateException e) {

            if (tx != null) {
                tx.rollback();
            }

            System.err.println("Error creating Customer :" + e);
            e.printStackTrace();

        } finally {
            session.close();
        }

    }
}