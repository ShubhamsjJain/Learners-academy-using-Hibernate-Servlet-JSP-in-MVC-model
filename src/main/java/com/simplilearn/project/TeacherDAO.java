package com.simplilearn.project;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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

}
