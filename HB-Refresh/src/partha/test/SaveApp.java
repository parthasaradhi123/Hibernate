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
		 Integer id = 1;
		boolean flag = false;
		try
		{
			session = HibernateUtility.getSession();
			 Student student = session.get(Student.class, id);
			 
			 System.out.println("Data before updation from database side");
			System.out.println(student);
			if(student!=null)
			{
			System.in.read();
			session.refresh(student);
			
			System.out.println("Data After updation from database side");
			System.out.println(student);
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
			 
			
			HibernateUtility.closeSession(session);
			HibernateUtility.closeSessionFactory();
		}
}

}
