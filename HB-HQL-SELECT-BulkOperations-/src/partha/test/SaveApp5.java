package partha.test;

import java.util.List;

 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import partha.model.DiffClass;
import partha.util.HibernateUtility;

public class SaveApp5 {

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
				query = session.createQuery("FROM partha.model.DiffClass WHERE id=:prod");//select * from diffclass;
				
				query.setParameter("prod", 2);
				 
			
				//Execute the query
				 List<DiffClass> name =query.getResultList();
				 System.out.println(name.size());
				 //proccess the list.
				 if(!name.isEmpty())
				 {
					 name.forEach(System.out::println);
				 }
				 else
				 {
					 System.out.println("Record Not Found.");
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
