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
    
    public TeacherControllerServlet() {
        
    }

	
	@Override
	public void init() throws ServletException {
		
		teacherdao = new TeacherDAO();
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
					
					
			    case "ADD":
			
			        //Add the students in MVC fashion 
			    
			        
			        
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
