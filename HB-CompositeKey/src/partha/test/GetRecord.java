package partha.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import partha.model.ProjectId;
import partha.model.ProjectInfo;
import partha.util.HibernateUtility;

public class GetRecord 
{

	public static void main(String[] args)
	{

		Session session = null;
		try
		{
			session = HibernateUtility.getSession();
			if(session!=null)
			{
			 
				ProjectId pid = new ProjectId();
				pid.setPid(100);
				pid.setProjectId(502);
				
				ProjectInfo object = session.get(ProjectInfo.class, pid);
 				if(object!=null)
 				{
 					System.out.println(object);
 				}
 				else
 				{
 					System.out.println("data not available for given id "+pid);
 				}
 			}
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			HibernateUtility.closeSession(session);
			HibernateUtility.closeSessionFactory();

		}

	}
}
