package partha.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import partha.model.Student;

 

public class MainApp {

	public static void main(String[] args) 
	{
		
		// 1.Inform Jvm to Activate Hibernate Software.
			Configuration config = new Configuration();
			config.configure();
			
			
			SessionFactory sessionFactory =config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
		
		// 2.Create persistence Object.
		
			Student student = new Student();
			student.setId(1);
			student.setName("Suchi");
			student.setAge(26);
			student.setAddress("kadapa");
		
		// 3.Perform persistence operation using Entitiy/Model/Pojo object.
			session.save(student);		

		// 4.If we say transaction.commit then the query will be sent to database and it will get executed.
			transaction.commit();
			
			System.out.println("The data has been successfully saved into database.");
	}

}
