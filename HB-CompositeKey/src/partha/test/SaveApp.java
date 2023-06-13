package partha.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import partha.model.ProjectId;
import partha.model.ProjectInfo;
import partha.util.HibernateUtility;

public class SaveApp {

	public static void main(String[] args)
	{
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		ProjectId primaryKey = null;
		Integer id = null;
		try
		{
			session = HibernateUtility.getSession();
			if(session!=null)
			{
				transaction = session.beginTransaction();
			}
			if(transaction!=null)
			{
				ProjectId pid = new ProjectId();
				pid.setPid(100);
				pid.setProjectId(502);
				
				ProjectInfo pinfo = new ProjectInfo();
				
				pinfo.setId(pid);
				pinfo.setPname("sachin");
				pinfo.setDeptno(10);
				pinfo.setProjName("INDIA");
				 
		     	primaryKey = (ProjectId)session.save(pinfo);
				
				 flag = true;
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
			if(flag)
			{
				transaction.commit();
				System.out.println("Data saved in database with primarykey ::"+primaryKey);
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
