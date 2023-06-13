package partha.test;

import java.util.List;
import java.util.Optional;

 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import partha.model.DiffClass;
import partha.util.HibernateUtility;

public class DeleteApp
{

	public static void main(String[] args)
	{
		Session session = null;
		boolean flag = false;
		Transaction txn = null;
		Integer rowAffected = null;
		
  		try
		{
			session = HibernateUtility.getSession();
			txn = session.beginTransaction();
			
			if(txn!=null)
			{
				Query  query = session.createQuery("DELETE FROM partha.model.DiffClass WHERE id=:prod");
				query.setParameter("prod", 5);
			
				  rowAffected = query.executeUpdate();
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
				txn.commit();
				System.out.println(rowAffected +" row deleted SUCCESSFULLY.");
			}
			else
			{
				txn.rollback();
				System.out.println("Not deleted");
			}
			HibernateUtility.closeSession(session);
			HibernateUtility.closeSessionFactory();
		}
}

}
