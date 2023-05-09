package com.simplilearn.project;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SubjectDAO {
	
private SessionFactory factory;

public SubjectDAO() {
	
	factory = HibernateUtil.getSessionFactory();
}

public List<Subject> getSubjects()throws Exception {
	
	Session session = factory.openSession();
	
	try {
		
	List<Subject> list = session.createQuery("from Subject").list(); 
	
	return list; 
	
	}finally {
		
		session.close();
	}
	
}

public void addSubject(String subject_name, String[] class_names) {
	
	Session session = factory.openSession();
	Transaction transaction = null;
	
	try {
		
		//Begin transaction
		
		transaction = session.beginTransaction();
		
		//Check if the subject entity  with the specified subject name already exists in the database
		
		Query q = session.createQuery("from Subject s where s.s_name = :name");
		q.setParameter("name",subject_name);
		Subject subject = (Subject) q.uniqueResult(); //Note that we are using uniqueResult rather than getSingleResult method to retrieve class entity 
		                                                             //because if query return no result then uniqueResult method will give null 
		                                                             //while getSingleResult method will throw an exception
		
		//If the subject entity doesn't exist create a new one
		
		if(subject == null) {
			subject = new Subject();
			subject.setS_name(subject_name);
			session.save(subject);
		}
		
		//Now after getting subject entity using subject_name or creating a new subject entity if one doesn't exist
		//For each selected class_name ,check if the class already exists in the database for that class name
		
		for(String c_name : class_names) {  // i.e we are checking for each classname entered by user one by one 
			                                //using string array in which we stored all entered class_names
			                                //though now since i have provided dropdown list of classes and 
			                                //taking only 1 classname hence no need of either for loop or checking whether class name exists or not 
			Query query = session.createQuery("from ClassDetails c where c.name = :name");
			query.setParameter("name",c_name);
			ClassDetails classdetail = (ClassDetails) query.uniqueResult();
		
			
		      // If the ClassDetails entity doesn't exist for that class name then create a new one and add it to database
		
			
			    if(classdetail == null) {
			    	classdetail = new ClassDetails();
			    	classdetail.setName(c_name);
			    	session.save(classdetail);
			    }
			    
			    
			    //Add the associations between subject and class to the database
			    
			    if(subject != null) {
			    subject.getClasses().add(classdetail);  //It will give list of all ClassDetails Entity associated
			                                            // with that subject_name and hence add new ClassDetails entity in that list.
		
		              if(classdetail != null) {
			           classdetail.getSubjects().add(subject); //It will give list of all Subject Entity associated
                                                               // with that Class_name and hence add new Subject entity in that list.
		              }
			    }else {
			    	
			    }
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
