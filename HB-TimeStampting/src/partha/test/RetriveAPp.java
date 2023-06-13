package partha.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import partha.model.BankAccount;
import partha.util.HibernateUtility;

public class RetriveAPp {

	public static void main(String[] args)
	{
		Session session = null;
		Long id =1l;
		Transaction transaction = null;
		 BankAccount account = null;
		boolean flag = false;
		 
		try
		{
			session = HibernateUtility.getSession();
			if(session!=null)
			{
				account = session.get(BankAccount.class, id);
				 System.out.println("Before modifcation :: "+account);
 				if(account!=null)
 				{
 					transaction = session.beginTransaction();
 					account.setBalance(3000l);
 					flag = true;
 				}
 				else
 				{
 					System.out.println("data not available for given :: "+id);
 					System.exit(0);
 				}
				 
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
				System.out.println("After modifcation ");
				System.out.println("Account opening date :: "+account.getOpeningDate());
				System.out.println("Account last updated :: "+account.getLastUpdated());
				System.out.println("Account version coutnt :: "+account.getCount());
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
