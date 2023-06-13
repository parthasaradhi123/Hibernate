package partha.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import partha.model.DiffClass;
 import partha.util.HibernateUtility;

public class LoadMerge {

	public static void main(String[] args)
	{
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		DiffClass student = null;
		DiffClass df = null;
		DiffClass obj = null;
		
		try
		{
			session = HibernateUtility.getSession();
			df =  session.get(DiffClass.class, 2);
 			System.out.println(df);
			if(session!=null)
			{
				transaction = session.beginTransaction();
			}
			if(transaction!=null)
			{
				  student = new DiffClass();
				student.setId(2);
				 student.setAge(28);
				 student.setAddress("banglore");
				 student.setName("delip");
				 
				 //session.saveOrUpdate(student);
				obj =  (DiffClass)session.merge(student);
 					System.out.println("data after merge :: "+obj);

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
				System.out.println("Data saved in database.");
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
