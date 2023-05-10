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


	public void addTeacher(String cla, String teacher)throws Exception {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			
			//Begin transaction
			
			transaction = session.beginTransaction();
			
			// NO NEED TO CHECK WHETHER GIVEN CLASSNAME EXIST OR NOT 
			//BECAUSE I HAVE TAKEN IT FROM DYNAMICALLY GENERATED DROP DOWN LIST OF EXISTING CLASSES
			
			//Get the already existing object for given classname
			
			Query q = session.createQuery("from ClassDetails c where c.name = :name");
			q.setParameter("name",cla);
			ClassDetails cla_object = (ClassDetails) q.uniqueResult(); //Note that we are using uniqueResult rather than getSingleResult method to retrieve class entity 
			                                                             //because if query return no result then uniqueResult method will give null 
			                                                             //while getSingleResult method will throw an exception
			
			
			//NOW SIMILARLY NO NEED TO CHECK WHETHER GIVEN TEACHER NAME EXIST OR NOT 
			//BECAUSE I HAVE TAKEN IT FROM DYNAMICALLY GENERATED DROP DOWN LIST OF EXISTING TEACHERS
			
			//Get the already existing object for given teacher name	
			
						
			Query query = session.createQuery("from Teacher t where t.name = :name");
		    query.setParameter("name",teacher);
		    Teacher tea = (Teacher) query.uniqueResult();
			
				
			      
				    
				    
		   //Add the associations between class and Teacher to the database
				    
		    if(tea != null) {
				 tea.getClasses().add(cla_object);  //It will give list of all class Entity associated
				                                    // with that teacher and hence add new teacher entity in that list.
			
			      if(cla_object != null) {
			    	  cla_object.getTeachers().add(tea); //It will give list of all teachers Entity associated
	                                                     // with that class and hence add new teacher entity in that list.
			              }
				    }else {
				    	
				    }
			
			
			
			//Commit transaction
			
			transaction.commit();
			
			
			
		}catch(HibernateException e) {
			
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			
			
			session.close();
		}
		
		
		
		
	}

}
