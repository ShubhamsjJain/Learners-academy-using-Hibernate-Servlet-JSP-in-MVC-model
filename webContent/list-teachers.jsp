<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.simplilearn.project.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teachers List</title>
<link  type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%

//Get the teachers from the request object (sent by the servlet)
List<Teacher> teachers = (List<Teacher>)request.getAttribute("TEACHER_LIST");   

%>
<body>

<div id="wrapper">

     <div id="header">
          <h2>Learners Academy</h2>
     </div>
  </div>
  
  
  <div id="container">
  
      <div id="content">
      
         <!-- Adding Add Teachers Button that will take to add-teachers-form -->
         
         
         <input type='button' 
         value='Add Teachers' 
         onclick="window.location.href='teachers?command=OPTION';return false;"
         class='add-student-button'
         />
         
         
         <table width=100%>
         
           <tr>
           
              <th>Teacher ID</th>
              <th>Teacher Name</th>
              <th>Teacher E-Mail</th>
              <th>Teacher City</th>
              <th>Teacher Subjects</th>
              <th>Classes assigned</th>
              <th>Action</th>
              
           </tr>
           
           <% for(Teacher tea: teachers) {%>
                
               <tr>
                     <td><%= String.valueOf(tea.getID())%></td>
                     <td><%= tea.getName()%></td>
                     <td><%= tea.getE_mail()%></td>
                     <td><%= tea.getCity()%></td>
                     
             
               <!-- Print Subjects for this Teacher -->
               
                            
            		   
            		           
                
                     <td><ul>
                     
                     <% if(tea.getS_objects() != null && !tea.getS_objects().isEmpty()){ %>
                     
                          <% for(Subject s: tea.getS_objects()) {%>
                     
                                 <%= s.getS_name()%><br>
                      
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