package com.simplilearn.project;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TeacherControllerServlet
 */
@WebServlet("/TeacherControllerServlet")
public class TeacherControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private TeacherDAO teacherdao;
    private SubjectDAO subjectdao;
    
    public TeacherControllerServlet() {
        
    }

	
	@Override
	public void init() throws ServletException {
		
		teacherdao = new TeacherDAO();
		subjectdao = new SubjectDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
try {
			
			String theCommand = request.getParameter("command");   // taking command parameter having value ADD or UPDATE or DELETE
			
			// if theCommand is missing,default it to listteachers
			
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			switch(theCommand){
				
			
		        case "LIST":
					//List the teachers in MVC fashion
		        	listTeachers(request,response);    //Provided below
			        break;
					
			        
		        case "OPTION":
			    	
				    //Get list of all subject objects to get subject names from that objects 
		        	//which we will use in option tag in add teacher form
			    	
			    	
			    	subjectObjects(request,response);    //Provided below
			        break;
					
			    case "ADD":
			
			        //Add the teachers in MVC fashion 
			    
			    	addTeachers(request,response);    //Provided below
			        break;
			        
			        
			    case "LOAD":
			    	
			    	//Load all student info from database based on student id got from list-student.jsp
			    	
			    	
			    	
			    case "UPDATE":
			    	
			    	//Update the student in MVC fashion 
			    	
			    	
			    	
                case "DELETE":
			    	
			    	//Delete the student in MVC fashion 
			    	
			    	
			        
			     default:
			    	 
			    	  //Provided below
					 
			
			}
			
			
			
		} catch (Exception e) {
						
			e.printStackTrace();
		}  
	}

	private void addTeachers(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		//Read teacher info from form data
		
		String name = request.getParameter("name");
		String e_mail = request.getParameter("e_mail");
		String city = request.getParameter("place");
		String subject = request.getParameter("subject");
		
		//Send this teacher info to TeacherDAO in order to insert it into database
		
		teacherdao.addTeacher(name, e_mail, city, subject);
		
		
		//Send back to list-teacher page
		
		listTeachers(request,response);
	}


	private void subjectObjects(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		List<Subject> subjects = subjectdao.getSubjects();
		
		request.setAttribute("SUBJECT_OPTIONS", subjects);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-teacher-form.jsp");
		
		dispatcher.forward(request, response);
		
	}


	private void listTeachers(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		//Get all Teacher class objects in list from TeacherDAO class
		
		List<Teacher> teacher_objects = teacherdao.getTeachers();
		
		//Add teacher_objects to the Attribute of request object
		
		request.setAttribute("TEACHER_LIST", teacher_objects);
		
		// Send to JSP page (view) using Request dispatcher (Building connection between servlet(controller) and JSP(view))
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-teachers.jsp");
		
		dispatcher.forward(request, response);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
