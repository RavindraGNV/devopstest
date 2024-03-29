package in.ineuron.util;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static Configuration cfg = null;
	static SessionFactory sessionFactory ;
	static Session session = null;
	static {
		try {
			cfg = new Config
					uration();
			cfg.configure();
			sessionFactory = cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		if (session == null)
			session = sessionFactory.openSession();
		return session;
	}

	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}

	public static void closeSessionFactory(SessionFactory sessionFactory) {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
