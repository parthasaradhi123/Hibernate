package partha.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import partha.model.InsurancePolicy1;
 
public class HibernateUtility 
{
	private HibernateUtility()
	{
		
	}
	
	private static SessionFactory sessionFactory= null;
	private static Session session = null;
	
	
	
	
	static
	{
		sessionFactory = new Configuration().configure().addAnnotatedClass(InsurancePolicy1.class).buildSessionFactory();
	}
	
	
	
	public static Session getSession()
	{
		if(session==null)
		{
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public static void closeSession(Session session)
	{
		if(session!=null)
		{
			session.close();
		}
	}
	
	public static void closeSessionFactory()
	{
		if(sessionFactory!=null)
		{
			sessionFactory.close();
		}
	}
	
	
	
	
	
	
}
