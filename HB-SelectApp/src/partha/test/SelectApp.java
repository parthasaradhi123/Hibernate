package partha.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import partha.model.Student;
import partha.util.HibernateUtility;

public class SelectApp
{

	public static void main(String[] args)
	{
		Session session = null;
		Integer id =1;
		try
		{
			session = HibernateUtility.getSession();
			
			Student student = session.get(Student.class, id);
			if(student!=null)
			{
				System.out.println(student);
			}
			else
			{
				System.out.println("Record not found for the given Id :: "+id);
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
			
			HibernateUtility.closeSession(session);
			HibernateUtility.closeSessionFactory();
		}
}

}
