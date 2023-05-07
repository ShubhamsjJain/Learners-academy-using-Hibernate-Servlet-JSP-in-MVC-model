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
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private StudentDAO studentdao;
    
    public StudentControllerServlet() {
        
    }

	
	@Override
	public void init() throws ServletException {
		
		//Create StudentDAO object in init So that as soon as servlet starts it will create StudentDAO object and hence StudentDAO constuctor will be called where SessionFactory object is created.
		studentdao = new StudentDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
try {
			
			String theCommand = request.getParameter("command");   // taking command parameter having value ADD or UPDATE or DELETE
			
			// if theCommand is missing,default it to liststudents
			
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			switch(theCommand){
				
			
		        case "LIST":
					//List the students in MVC fashion
		        	listStudents(request,response);    //Provided below
			        break;
					
					
			    case "ADD":
			
			        //Add the students in MVC fashion 
			    
			        addStudents(request,response);    //Provided below
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

	private void listStudents(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		       //Get Student class objects in list from studentDAO class
		
				List<Student> students = studentdao.getStudents();
				
				//Add subjects to the Attribute of request object
				
				request.setAttribute("STUDENT_LIST", students);
				
				// Send to JSP page (view) using Request dispatcher (Building connection between servlet(controller) and JSP(view))
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("list-students.jsp");//where to forward
				dispatcher.forward(request, response);//what to forward
		
	}


	private void addStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		       //Read student info from form data
		
		
				String name = request.getParameter("name");
				String e_mail = request.getParameter("e_mail");
				String place = request.getParameter("place");
				String classinput = request.getParameter("classinput");
				
				
				
				//Send this student info to StudentDAO in order to insert it into database
				
				studentdao.addStudent(name,e_mail,place,classinput);
				
				//Send back to list-student page
				
				//listStudents(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
