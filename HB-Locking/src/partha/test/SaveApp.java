package partha.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import partha.model.InsurancePolicy1;
import partha.util.HibernateUtility;

public class SaveApp {

	public static void main(String[] args)
	{
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		InsurancePolicy1 policy = null;
		Integer id = null;
		
		
		try
		{
			session = HibernateUtility.getSession();
			if(session!=null)
			{
				transaction = session.beginTransaction();
			}
			if(transaction!=null)
			{
				policy = new InsurancePolicy1();
				policy.setName("partha");
				policy.setPtype("jeevan");
				policy.setTenure(3);
				
			id =(Integer)session.save(policy);
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
				System.out.println("Data saved in database with id "+id);
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
