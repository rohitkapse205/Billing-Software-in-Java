package com.app.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.model.Bill;

public class HibernateUtil {

	public static SessionFactory factory = null;
	public static Session session = null;
	static ThreadLocal<Session> tl = new ThreadLocal<Session>();

	static {

		try {
			factory = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
			Bill user = new Bill();
			session.persist(user);
			Transaction tx = session.beginTransaction();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		try {
			if (tl.get() == null) { // get from ThreadLocal
				session = factory.openSession();
				tl.set(session); // set into ThreadLocal
				return session;
			} else {
				return tl.get(); // get from ThreadLocal
			}
		} // try
		catch (Exception e) {
			return null;
		}
	}// method

	public static void cloesSession() {
		session.close();

	}
}
