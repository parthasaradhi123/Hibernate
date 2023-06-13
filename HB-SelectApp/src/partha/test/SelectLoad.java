package partha.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import partha.model.Student;
import partha.util.HibernateUtility;

public class SelectLoad
{

	public static void main(String[] args)
	{
		Session session = null;
		Integer id =1;
		try
		{
			session = HibernateUtility.getSession();
			
			Student student = session.load(Student.class, id);
			if(student!=null)
			{
				System.out.println(student.getId());
				 System.in.read();
				System.out.println(student.getName());
				System.out.println(student.getAge());
				System.out.println(student.getAddress());
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
