package partha.test;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.HibernateException;
import org.hibernate.Session;
 
import partha.model.JobSeeker;
import partha.util.HibernateUtility;

public class Retrive {

	public static void main(String[] args)
	{
		Session session = null;
		JobSeeker seeker = null;
		Integer id = 1;
 		try
		{
			session = HibernateUtility.getSession();
			if(session!=null)
			{
				seeker = session.get(JobSeeker.class, id);
				
			if(seeker!=null)
			{
				System.out.println("person id is :: "+seeker.getJsId());
				System.out.println("person Name is :: "+seeker.getJsName());
				System.out.println("person Address is :: "+seeker.getJsAddress());
				
				try(FileOutputStream fos = new FileOutputStream("D:\\Images\\sun.jpeg"))
				{
					fos.write(seeker.getPhoto());
					System.out.println("Photo downloaded");
				}
				
				try(FileWriter fr = new FileWriter("D:\\Images\\kadapa.txt"))
				{
					fr.write(seeker.getResume());
					System.out.println("text downloaded");
				}
				
			}
			else
			{
				System.out.println("Record Not Available for the given :: "+id);
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
