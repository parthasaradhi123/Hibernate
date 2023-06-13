package partha.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import partha.model.Student;
import partha.util.HibernateUtility;

public class RetriveAPp {

	public static void main(String[] args)
	{
		Session session = null;
		 
		try
		{
			session = HibernateUtility.getSession();
			if(session!=null)
			{
				 
				Student student=session.get(Student.class, 1);
				
				if(student!=null)
				{
					System.out.println(student);
				}
				else
				{
					System.out.println("data not avalaibale for given id");
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
			
			HibernateUtility.closeSession(session);
			HibernateUtility.closeSessionFactory();
		}
}

}
