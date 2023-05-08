package com.simplilearn.project;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SubjectControllerServlet")
public class SubjectControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SubjectDAO subjectdao;
	private ClassDAO classdao;
       
    
    public SubjectControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException {
		
		//Create SubjectDAO object in init So that as soon as servlet starts it will create SubjectDAO object and hence SubjectDAO constuctor will be called where SessionFactory object is created.
    	subjectdao = new SubjectDAO();
    	classdao = new ClassDAO();
	}
        
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
try {
			
			String theCommand = request.getParameter("command");   // taking command parameter having value ADD or UPDATE or DELETE
			
			// if theCommand is missing,default it to listssubjects
			
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			switch(theCommand){
			
			
			    case "OPTION":
			    	
			    //Get list having class names to use it in option tag in add subject form
		    	
		    	
		    	classNames(request,response);    //Provided below
		        break;
				
			
		        case "LIST":
					//List the subjects in MVC fashion
		        	listSubjects(request,response);    //Provided below
			        break;
					
					
			    case "ADD":
			
			        //Add the subjects in MVC fashion 
			    	
			    	addSubjects(request,response);    //Provided below
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

	
	private void addSubjects(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		//Read subject info from form data
		
		String subject_name = request.getParameter("subject");
		
		
		String[] class_names = request.getParameterValues("class[]"); //getParametervalues bring all values with same name in string[] format
		
		
		//Send this subject info to SubjectDAO in order to insert it into database
		
		subjectdao.addSubject(subject_name,class_names);
		
		//Send back to list-subjects page
		
		listSubjects(request,response);  
		
	}

	private void classNames(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		//Get ClassDetails class objects in list from classDAO class from which later I will extract only class names
		
				List<ClassDetails> classdetails = classdao.getclasses();
				
				//Add classdetails to the Attribute of request object
				
				request.setAttribute("CLASS_LIST", classdetails);
				
				// Send to add-subject-form.jsp using Request dispatcher (Building connection between servlet(controller) and JSP(view))
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("add-subject-form.jsp");//where to forward
				dispatcher.forward(request, response);//what to forward
		
	}

	private void listSubjects(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		//Get Subject class objects in list from SubjectDAO class
		
		List<Subject> subjects = subjectdao.getSubjects();
		
		//Add subjects to the Attribute of request object
		
		request.setAttribute("SUBJECT_LIST", subjects);
		
		// Send to JSP page (view) using Request dispatcher (Building connection between servlet(controller) and JSP(view))
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-subjects.jsp");//where to forward
		dispatcher.forward(request, response);//what to forward
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
