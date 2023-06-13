package partha.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import partha.model.CustomerMobile;
import partha.util.HibernateUtility;

public class RetriveAPp {

	public static void main(String[] args)
	{
		Session session = null;
		 boolean flag = false;
		 Transaction transaction=null;
		 CustomerMobile object = null;
		try
		{
			session = HibernateUtility.getSession();
			if(session!=null)
			{
				 object= session.get(CustomerMobile.class, 1); 
				
				System.out.println("Before Modification :: "+object);
				transaction = session.beginTransaction();
				object.setCallerTune("lalallalalaa");
				
				session.update(object);
				flag = true;
				 
			}
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{ 
			if(flag)
			{
				transaction.commit();
				System.out.println("object updated to database");
				System.out.println("After modification::"+object);
			}
			else
			{
				transaction.rollback();
				System.out.println("Object not updated");
			}
			
			HibernateUtility.closeSession(session);
			HibernateUtility.closeSessionFactory();
		}
}

}
