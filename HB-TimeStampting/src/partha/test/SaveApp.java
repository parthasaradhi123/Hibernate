package partha.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import partha.model.BankAccount;
 import partha.util.HibernateUtility;

public class SaveApp {

	public static void main(String[] args)
	{
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		Long id =  null;
		
		try
		{
			session = HibernateUtility.getSession();
			if(session!=null)
			{
				transaction = session.beginTransaction();
			}
			if(transaction!=null)
			{
				BankAccount account = new BankAccount();
				account.setHolderName("partha");
				account.setBalance(2000l);
				account.setType("savings");
				
				id=(Long)session.save(account);
				
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
				System.out.println("Data saved in database with id ."+id);
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
