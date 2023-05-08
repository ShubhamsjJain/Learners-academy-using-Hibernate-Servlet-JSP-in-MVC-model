package com.simplilearn.project;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	
	

}
