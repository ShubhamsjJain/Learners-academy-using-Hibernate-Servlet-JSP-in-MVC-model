<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.simplilearn.project.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding teacher to class</title>
<link  type="text/css" rel="stylesheet" href="css/style.css">
<link  type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<% Subject subject =(Subject)request.getAttribute("SUBJECT_OBJECT");%>
<body>

<div id="wrapper">

     <div id="header">
          <h2>Learners Academy</h2>
     </div>
  </div>
  
  
  <div id="container">
  
      <div id="content">
      
        <h3>Adding teacher to class</h3>   
      
         
         
         <form action="" method="get">
             
             <table>
             
                   <tr>
                       <td><label>For Subject:</label></td>
                       <td><strong><%= subject.getS_name() %></strong></td>                
                   </tr>
                   
                   <tr>
                       <td><label>In which Class:</label></td>
                       
                            <% if(subject.getClasses() != null && !subject.getClasses().isEmpty()) { %>
                            
                                      <td><select  name="cla">
           
                                           <% for(ClassDetails c : subject.getClasses()){%>
                
                                                   <option value="<%= c.getName()%>"><%= c.getName()%></option>
                
                                            <% } %>
                
                                            </select></td>
                             <% }else{ %>
                             
                                       <td>Sorry this subject has not yet been made available in any class</td>
                              <% } %>
                   </tr> 
                   
                   <tr>
                       <td><label>Select Teacher:</label></td>
                       
                            <% if(subject.getT_objects() != null && !subject.getT_objects().isEmpty()) { %>
                            
                                      <td><select  name="teacher">
           
                                           <% for(Teacher t : subject.getT_objects()){%>
                
                                                   <option value="<%= t.getName()%>"><%= t.getName()%></option>
                
                                            <% } %>
                
                                            </select></td>
                             <% }else{ %>
                             
                                         <td>Sorry No Faculty Available</td>
                              <% } %>
                   
                   </tr>       
                   <tr>
                        <td></td>
                        <td><input type="submit" value="Submit"/></td>
                   
                   </tr>    
             
             </table>
         
         </form>
                     
         
      </div>
     
  
  </div>
</body>
</html>