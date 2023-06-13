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
 				 policy = session.get(InsurancePolicy.class, id); // gets data from database keeps it in L2 and L1 cache
 				 
 				 System.out.println(policy);
 				 System.out.println("-1111-------------------------------------------");
			
 				 policy = session.get(InsurancePolicy.class, id); // these time it will fetch the data from L1 cache.
				 System.out.println(policy);
				 System.out.println("-2222-------------------------------------------");
				 
				 session.evict(policy); //Removing the policy object from L1 cache.
				 
				 policy = session.get(InsurancePolicy.class, id); // these time it will fetch the data from L2 cache, because data is not available in L!
				 System.out.println(policy);
				 System.out.println("-333-------------------------------------------");
				 
				 
				 
					 
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
