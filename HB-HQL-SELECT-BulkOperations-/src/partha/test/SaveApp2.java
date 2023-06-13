package partha.test;

import java.util.List;

 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import partha.model.DiffClass;
import partha.util.HibernateUtility;

public class SaveApp2 {

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
				query = session.createQuery("FROM partha.model.DiffClass WHERE id IN(:prod,:prod1)");//select * from diffclass;
				
				query.setParameter("prod", 4);
				query.setParameter("prod1", 5);
				
				
				
				//Execute the query
				 List<DiffClass> name =query.list();
				 
				 
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
