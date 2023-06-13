package partha.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
 
 import partha.model.InsurancePolicy;
import partha.util.HibernateUtility;

public class RetriveAPp {

	public static void main(String[] args)
	{
		Session session = null;
		Long id =1l;
 		InsurancePolicy policy = null;
 		 
		try
		{
			session = HibernateUtility.getSession();
			if(session!=null)
			{
 				 policy = session.get(InsurancePolicy.class, id); // gets data from database keeps it in L1 cache
 				 
 				 System.out.println(policy);
 				 System.out.println("-1111-------------------------------------------");
			
 				policy = session.get(InsurancePolicy.class, id); // these time it will fetch the data from L1 cache.
				 
				 System.out.println(policy);
				 System.out.println("-2222-------------------------------------------");
				 
				 session.evict(policy);
				 
				 policy = session.get(InsurancePolicy.class, id); // these time it will fetch the data from database and keeps it in database.
				 System.out.println(policy);
				 System.out.println("---333-----------------------------------------");
				 
				 policy = session.get(InsurancePolicy.class, id); // these time it will fetch the data from L1 cache.
				 System.out.println(policy);
				 System.out.println("---444-----------------------------------------");
				 
				 session.clear(); // It will remove all the objects from the Cache.
				 
				 policy = session.get(InsurancePolicy.class, id); // these time it will fetch the data from database and keeps it in database.
				 System.out.println(policy);
				 System.out.println("---555-----------------------------------------");
				 
				 policy = session.get(InsurancePolicy.class, 2l); // these time it will fetch the data from database and keeps it in database.
				 System.out.println(policy);
				 System.out.println("---666-----------------------------------------");
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
