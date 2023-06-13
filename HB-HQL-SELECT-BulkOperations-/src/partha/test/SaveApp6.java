package partha.test;

import java.util.List;

 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import partha.model.DiffClass;
import partha.util.HibernateUtility;

public class SaveApp6 {

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
				
				query.setParameter("prod", 7);
				 
				 DiffClass dif = (DiffClass) query.uniqueResult();
				 if(dif!=null)
				 {
					 System.out.println(dif);
				 }
				 else
				 {
					 System.out.println("data not avalibale");
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
