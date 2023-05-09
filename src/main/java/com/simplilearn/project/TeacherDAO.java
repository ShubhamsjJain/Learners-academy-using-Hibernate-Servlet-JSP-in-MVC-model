package com.simplilearn.project;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TeacherDAO {

	private SessionFactory factory;
	
	
	public TeacherDAO() {
		
		factory = HibernateUtil.getSessionFactory();
	}


	public List<Teacher> getTeachers() {
		
       Session session = factory.openSession();
		
		try {
			
		List<Teacher> list = session.createQuery("from Teacher").list(); 
		
		return list; 
		
		}finally {
			
			session.close();
		}
	}


	public void addTeacher(String name, String e_mail, String city, String subject) {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			
			//Begin transaction
			
			transaction = session.beginTransaction();
			
			//Check if the teacher entity  with the specified email already exists in the database
			
			Query q = session.createQuery("from Teacher t where t.e_mail = :name");
			q.setParameter("name",e_mail);
			Teacher teacher = (Teacher) q.uniqueResult(); //Note that we are using uniqueResult rather than getSingleResult method to retrieve class entity 
			                                                             //because if query return no result then uniqueResult method will give null 
			                                                             //while getSingleResult method will throw an exception
			
			//If the teacher entity doesn't exist create a new one
			
			if(teacher == null) {
				teacher = new Teacher();
				teacher.setName(name);
				teacher.setE_mail(e_mail);
				teacher.setCity(city);
				session.save(teacher);
			}
			
			//Now after getting teacher entity using email or creating a new teacher entity if one doesn't exist
			//check if the subject already exists in the database for that subject name
			
			
				Query query = session.createQuery("from Subject s where s.s_name = :name");
				query.setParameter("name",subject);
				Subject sb = (Subject) query.uniqueResult();
			
				
			      // If the Subject entity doesn't exist for that subject name then create a new one and add it to database
				  //Though no need to check whether subject exist or not because i have already provided drop down list of subjects
			      //Checking it for concept understanding
				
				    if(sb == null) {
				    	sb = new Subject();
				    	sb.setS_name(subject);
				    	session.save(sb);
				    }
				    
				    
				    //Add the associations between subject and Teacher to the database
				    
				    if(teacher != null) {
				    	teacher.getS_objects().add(sb);  //It will give list of all subject Entity associated
				                                            // with that teacher and hence add new subject entity in that list.
			
			              if(sb != null) {
				           sb.getT_objects().add(teacher); //It will give list of all teachers Entity associated
	                                                               // with that subject and hence add new teacher entity in that list.
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
