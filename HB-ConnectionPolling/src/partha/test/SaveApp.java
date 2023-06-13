package partha.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import partha.model.HikariConnection;
 import partha.util.HibernateUtility;

public class SaveApp {

	public static void main(String[] args)
	{
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try
		{
			session = HibernateUtility.getSession();
			if(session!=null)
			{
				transaction = session.beginTransaction();
			}
			if(transaction!=null)
			{
				HikariConnection student = new HikariConnection();
				 student.setAge(25);
				 student.setAddress("chennur");
				 student.setName("partha");
				 
				 session.save(student);
				 flag = true;
			}
		}
		catch(HibernateException e)
		{
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			if(flag)
			{
				transaction.commit();
				System.out.println("Data saved in database.");
			}
			else
			{
				transaction.rollback();
			}
			
			HibernateUtility.closeSession(session);
			HibernateUtility.closeSessionFactory();
		}
}

}
