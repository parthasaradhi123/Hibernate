package partha.test;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import partha.model.InsurancePolicy1;
import partha.util.HibernateUtility;

public class ClientApp {

	public static void main(String[] args)
	{
		Session session = null;
		Integer id = 1;
		Transaction transaction = null;
		boolean flag = false;
		
		
		try
		{
			session = HibernateUtility.getSession();
			if(session!=null)
			{
				transaction = session.beginTransaction();
				InsurancePolicy1 ip = session.get(InsurancePolicy1.class,id,LockMode.UPGRADE_NOWAIT );
				
				Thread.sleep(30000);
				ip.setTenure(10);
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
				System.out.println("Data saved to database.");
			}
			else
			{
				transaction.rollback();
				System.out.println("Data Not saved to data base.");
			}
			
			HibernateUtility.closeSession(session);
			HibernateUtility.closeSessionFactory();
		}
}

}
