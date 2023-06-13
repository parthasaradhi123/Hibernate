package partha.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import partha.model.JobSeeker;
 import partha.util.HibernateUtility;

public class Insert {

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		byte[] photo = null;
		char[] resume =null;
		Integer id = null;
		
		File f = null;
		
			//Logic to load a image file and save it in the byte[] array.
				try(FileInputStream fis = new FileInputStream("D:\\Images\\sunny.jpeg"))
				{
					  photo = new byte[fis.available()];
					
					fis.read(photo);
					
				}
				
				//logic to load a normal text file and save it in character array.

				try {	
					 f = new File("D:\\Images\\Andhra.txt");
					 FileReader fr = new FileReader(f);
					
						resume =new char[(int) f.length()];
						fr.read(resume);
						
						fr.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				 
				 
			 
			 
		 
	try
	{
		session = HibernateUtility.getSession();
		if(session!=null)
		{
			transaction = session.beginTransaction();
		}
		if(transaction!=null)
		{
			JobSeeker js = new JobSeeker();
			js.setJsName("partha");
			js.setJsAddress("kadapa");
			js.setPhoto(photo);
			js.setResume(resume);
			
			id=(Integer)session.save(js);
			
			flag = true;
		}
	}
			catch(HibernateException e1)
			{
			
			}
			catch(Exception e)
			{
			
			}
			finally
			{
				if(flag)
				{
					transaction.commit();
					System.out.println("Data saved in database."+id);
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
