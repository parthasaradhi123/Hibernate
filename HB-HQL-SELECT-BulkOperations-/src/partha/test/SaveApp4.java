package partha.test;

import java.util.List;

 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import partha.model.DiffClass;
import partha.util.HibernateUtility;

public class SaveApp4 {

	public static void main(String[] args)
	{
		Session session = null;
		Query query = null;
 		try
		{
			session = HibernateUtility.getSession();
			
			if(session!=null)
			{
				//Select all query using HQL Query.
				query = session.createQuery("SELECT name FROM partha.model.DiffClass WHERE id IN(:prod,:prod1)");//select * from diffclass;
				
				query.setParameter("prod", 1);
				query.setParameter("prod1", 2);
				 
			
				//Execute the query
				 List<String> name =query.getResultList();
				 
				 System.out.println(" NAME ");
				 //proccess the list.
				 name.forEach(System.out::println);
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
