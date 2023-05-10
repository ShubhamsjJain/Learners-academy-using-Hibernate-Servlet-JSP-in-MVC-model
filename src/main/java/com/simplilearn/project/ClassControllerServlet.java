package com.simplilearn.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClassControllerServlet
 */
@WebServlet("/ClassControllerServlet")
public class ClassControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ClassDAO classdao;
    public ClassControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
		
		//Create ClassDAO object in init So that as soon as servlet starts it will create ClassDAO object and hence ClassDAO constuctor will be called where SessionFactory object is created.
    	classdao = new ClassDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
try {
			
			String theCommand = request.getParameter("command");   // taking command parameter having value ADD or UPDATE or DELETE
			
			// if theCommand is missing,default it to liststudents
			
			if(theCommand == null) {
				theCommand = "OPTION";
			}
			
			switch(theCommand){
				
			
			    case "OPTION":
				    //Get list having class names to use it in option tag
			    	
			    	
			    	classNames(request,response);    //Provided below
			        break;
			
		        case "LIST":
					//List the classes in MVC fashion
		        	
		        	listClasses(request,response);    //Provided below
			        break;
					
					
			    case "ADD":
			
			        //Add the students in MVC fashion 
			    	
			    case "ADDTEACHER":
			    	
					//Add teacher in class for a subject in MVC fashion
		        	addTeacher(request,response);    //Provided below
			        break;
			    	
			    
			        
			        
			    case "LOAD":
			    	
			    	//Load all student info from database based on student id got from list-student.jsp
			    	
			    	
			    	
			    case "UPDATE":
			    	
			    	//Update the student in MVC fashion 
			    	
			    	
			    	
                case "DELETE":
			    	
			    	//Delete the student in MVC fashion 
			    	
			    	
			        
			     default:
			    	 
			    	 classNames(request,response);    //Provided below
				     break;
					 
			
			}
			
			
			
		} catch (Exception e) {
						
			e.printStackTrace();
		}  
	}

	private void addTeacher(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String cla = request.getParameter("cla");
		String teacher = request.getParameter("teacher");
		
		classdao.addTeacher(cla, teacher);
		
		classNames(request,response); 
		
		
		
	}

	private void listClasses(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		//Get class name selected from classoption.jsp page
		
		String classname = request.getParameter("className");
		
		//Get ClassDetails class objects in list from ClassDAO class for selected name
		
		ClassDetails classdetails = classdao.getClassReport(classname);
		
		//Add subjects to the Attribute of request object
		
		request.setAttribute("CLASS_REPORTLIST", classdetails);
		
		// Send to JSP page (view) using Request dispatcher (Building connection between servlet(controller) and JSP(view))
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-class.jsp");//where to forward
		dispatcher.forward(request, response);//what to forward
		
	}

	private void classNames(HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		
		//Get ClassDetails class objects in list from studentDAO class from which later I will extract only class names
		
		List<ClassDetails> classdetails = classdao.getclasses();
		
		//Add classdetails to the Attribute of request object
		
		request.setAttribute("CLASS_LIST", classdetails);
		
		// Send to classoptions.jsp using Request dispatcher (Building connection between servlet(controller) and JSP(view))
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("classoptions.jsp");//where to forward
		dispatcher.forward(request, response);//what to forward
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
