package partha.test;

import java.util.List;

 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import partha.model.DiffClass;
import partha.util.HibernateUtility;

public class SaveApp3 {

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
				query = session.createQuery("SELECT id,name,age FROM partha.model.DiffClass WHERE id IN(:prod,:prod1)");//select * from diffclass;
				
				query.setParameter("prod", 1);
				query.setParameter("prod1", 2);
				 
			
				//Execute the query
				 List<Object[]> name =query.list();
				 
				 System.out.println("ID\tNAME\t AGE");
				 //proccess the list.
				 name.forEach( row->{
							for(Object obj: row)
							 {
								 System.out.print(obj+"\t");
							 }
							System.out.println();
 						 });
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
