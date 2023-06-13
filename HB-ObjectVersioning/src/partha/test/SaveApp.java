package partha.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import partha.model.CustomerMobile;
import partha.util.HibernateUtility;

public class SaveApp {

	public static void main(String[] args)
	{
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
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
				CustomerMobile cm = new CustomerMobile();
				
				cm.setCallerTune("mateevinadugaa");
				cm.setCname("partha");
				cm.setCnumber(6305469143l);
				
				id = (Integer)session.save(cm);
				
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
