package partha.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import partha.model.Student;
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
				Student student = new Student();
				student.setName("partha");
				student.setDob(LocalDate.of(1998, 03, 03));
				student.setDom(LocalDateTime.of(2026, 04, 06, 18, 23));
				student.setDoj(LocalTime.of(9, 15));
				
				id =(Integer)session.save(student);
				 
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
