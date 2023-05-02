package com.mimaraslan.dao;

import com.mimaraslan.entity.Student;
import com.mimaraslan.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class StudentDao {
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(student);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Student> getStudents() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Student", Student.class).list();
		}
	}
}
