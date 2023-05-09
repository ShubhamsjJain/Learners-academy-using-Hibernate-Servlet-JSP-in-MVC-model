<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.simplilearn.project.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject list</title>
<link  type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
//Get the subjects from the request object (sent by the servlet)
List<Subject> theSubjects = (List<Subject>)request.getAttribute("SUBJECT_LIST");
%>

<body>

<div id="wrapper">

     <div id="header">
          <h2>Learners Academy</h2>
     </div>
  </div>
  
  
  <div id="container">
  
      <div id="content">
      
         <!-- Adding Add Subjects Button that will take to add-subject-form -->
         
         
         <input type='button' 
         value='Add Subject' 
         onclick="window.location.href='subjects?command=OPTION';return false;"
         class='add-student-button'
         />
         
         
         <table width=100%>
         
           <tr>
           
              <th>Subject ID</th>
              <th>Subject Name</th>
              <th>Class</th>
              <th>Faculties</th>
              <th>Action</th>
              
           </tr>
           
           <% for(Subject sub: theSubjects) {%>
                
               <tr>
                     <td><%= String.valueOf(sub.getID())%></td>
                     <td><%= sub.getS_name()%></td>
                     
             
               <!-- Print classes for this Subject -->
               
                            
            		   
            		           
                
                     <td><ul>
                     
                     <% if(sub.getClasses() != null && !sub.getClasses().isEmpty()){ %>
                     
                          <% for(ClassDetails cl: sub.getClasses()) {%>
                     
                                 <li><%= cl.getName()%></li>
                      
                          <% }%>
                     
                     <% }else{ %>
                     
                         None
                     
                     <% } %>
                     
                    
                     
                     </ul></td>
                     
                     
                                    <!-- Print Faculties for this Subject -->
               
                            
            		   
            		           
                
                     <td><ul>
                     
                     <% if(sub.getT_objects() != null && !sub.getT_objects().isEmpty()){ %>
                     
                          <% for(Teacher tea: sub.getT_objects()) {%>
                     
                                 <li><%= tea.getName()%></li>
                      
                          <% }%>
                     
                     <% }else{ %>
                     
                         None
                     
                     <% } %>
                     
           <% } %> 
                     
                    
                     
                     </ul></td>
                     
 
              </tr>
           
          
           
         </table>
         
         
      </div>
  
  </div>
  
</body>
</html>