package com.simplilearn.project;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClassDAO {

	private SessionFactory factory;
	
	
	public ClassDAO() {
		factory = HibernateUtil.getSessionFactory();
	}


	public List<ClassDetails> getclasses() {
      
		Session session = factory.openSession();
		
		try {
			
		List<ClassDetails> list = session.createQuery("from ClassDetails").list(); 
		
		return list; 
		
		}finally {
			
			session.close();
		}
		
	}


	public ClassDetails getClassReport(String classname)throws Exception{
		

		Session session = factory.openSession();
		
		
		try {
			
            session.beginTransaction();
			Query q = session.createQuery("from ClassDetails c where c.name = :name");
			q.setParameter("name",classname);
			ClassDetails classdetails = (ClassDetails) q.uniqueResult(); //It will give object(row) having name = classname req.
			                                                             // i.e it will give a class id,a class name and list of students w.r.t that classname
			
		    session.getTransaction().commit();
		return classdetails; 
		
		}finally {
			
			
			session.close();
		}
		
	}

}
