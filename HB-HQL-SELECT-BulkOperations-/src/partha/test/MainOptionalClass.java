package partha.test;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import partha.model.DiffClass;
import partha.util.HibernateUtility;

public class MainOptionalClass {

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
				
				query.setParameter("prod", 1);
				 
				Optional<DiffClass>optional = query.uniqueResultOptional();
				
				if(optional.isPresent())
				{
					DiffClass dif = optional.get();
					System.out.println(dif);
				}
				else
				{
					System.out.println("Record Not Avalibale.");
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
