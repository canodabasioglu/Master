package com.odabasioglu.utility;

/**
 * Copyright C@N
 * www.odabasioglu.net
 * 
 * Calendar Util
 * 
 * @author can odabasioglu
 * @version 1.0.2
 * @since 2005
 *
 */

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.odabasioglu.manager.LogManager;

public class HibernateUtility {

	static Logger loggingManager =
		Logger.getLogger(HibernateUtility.class.getName());

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory =
				new Configuration().configure().buildSessionFactory();

			loggingManager.warn("Hibernate Util Init Success");
		} catch (Exception e) {
			LogManager.logError(e.getMessage());
			loggingManager.error("Hibernate Util Init Error " + e.getMessage());
			throw new ExceptionInInitializerError(e);
		}

	}

	public static final ThreadLocal session = new ThreadLocal();

	public static Session currentSession() {
		Session s = (Session) session.get();
		if (s == null) {

			s = sessionFactory.openSession();
			loggingManager.warn("HibernateUtil Opening new Session");
			session.set(s);
		}
		return s;

	}

	public static void closeSession() {
		Session s = (Session) session.get();
		if (s != null)
			s.close();
		s.clear();
		loggingManager.warn("HibernateUtil Closing Session ");
		session.set(null);
	}

}
