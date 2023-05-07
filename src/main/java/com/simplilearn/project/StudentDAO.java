package com.simplilearn.project;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {

	private SessionFactory factory;
	
	public StudentDAO() {
		
		 factory = HibernateUtil.getSessionFactory();
	}

	public void addStudent(String name, String e_mail, String place, String classinput) {
		
		Session session = factory.getCurrentSession();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			//Check if the ClassDetails entity  with the specified classname already exists in the database
			
			Query q = session.createQuery("from ClassDetails c where c.name = :name");
			q.setParameter("name",classinput);
			ClassDetails classdetails = (ClassDetails) q.uniqueResult(); //Note that we are using uniqueResult rather than getSingleResult method to retrieve class entity 
			                                                             //because if query return no result then uniqueResult method will give null 
			                                                             //while getSingleResult method will throw an exception
			
			//If the class entity doesn't exist create a new one
			
			if(classdetails == null) {
				classdetails = new ClassDetails();
				classdetails.setName(classinput);
				session.save(classdetails);
			}
			
			//Now after getting class entity using classname or creating a new class entity if one doesn't exist
			//create a new student entity and save its properties including the associated class entity
			
			Student st = new Student();
			st.setName(name);
			st.setE_mail(e_mail);
			st.setCity(place);
			st.setClassdetails(classdetails);
			
			//Save the student entity to the database
			
			session.save(st);
			
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
