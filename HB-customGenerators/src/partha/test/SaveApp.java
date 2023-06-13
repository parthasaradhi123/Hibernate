package partha.test;

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
				 
				 student.setAddress("ram");
				 student.setName("jaishreeram");
				 student.setAge(25);
				 
				id =  (Integer)session.save(student);
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
				System.out.println("Data saved in database with id ::"+id);
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
