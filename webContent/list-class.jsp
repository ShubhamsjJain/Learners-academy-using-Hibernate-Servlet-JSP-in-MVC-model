<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.simplilearn.project.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class Report</title>
<link  type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
//Get the class report w.r.t classname entered from the request object (sent by the servlet)
ClassDetails classdetails = (ClassDetails)request.getAttribute("CLASS_REPORTLIST");

if(classdetails != null){
%>

<body>

<div id="wrapper">

     <div id="header">
          <h2>Class Report</h2>
     </div>
  </div>
  
  
  <div id="container">
  
      <div id="content">
      
         
         <table width=100%>
         
           <tr>
           
              <th>Class ID</th>
              <th>Class Name</th>
              <th>Student List</th>
              <th>Teacher List</th>
              <th>Subjects List</th>
              <th>Action</th>
              
           </tr>
           
           
                
               <tr>
                     <td><%= String.valueOf(classdetails.getID())%></td>
                     <td><%= classdetails.getName() %></td>
                     
                     <td>
                     
                          <% if(classdetails.getStu() != null && !classdetails.getStu().isEmpty()){ %>
                               <% for(Student stu: classdetails.getStu()) {%>
                     
                                        <%= stu.getName()%><br>
                      
                                <% }%>
                     
                          <% }else{ %>
                     
                         None
                     
                           <% } %>
                     
                    
                     
                     </td>
                     <td>
                     
                           <% if(classdetails.getTeachers() != null && !classdetails.getTeachers().isEmpty()){ %>
                           
                             <% for(Teacher teacher: classdetails.getTeachers()) {%>
                     
                                   <li><%= teacher.getName()%></li>
                      
                             <% }%>
                     
                     <% }else{ %>
                     
                                None
                     
                     <% } %>
                     
                     
                     
                     </td>
                     <td>
                     
                       
                     <% if(classdetails.getSubjects() != null && !classdetails.getSubjects().isEmpty()){ %>
                           
                             <% for(Subject subject: classdetails.getSubjects()) {%>
                     
                                   <li><%= subject.getS_name()%></li>
                      
                             <% }%>
                     
                     <% }else{ %>
                     
                                None
                     
                     <% } %>
                     
                    
                     
                     
                     
                     </td>
                     
                     
                     <td>
                        
                        <form action="subjects" method="get">
                        
                            <input type="hidden" name="command" value="GETSUBJECTOBJECT"/>
                            <h5>Add Teacher for Subject</h5>
                            <select name="subject">
           
                                  <% for(Subject s : classdetails.getSubjects()){%>
                
                                       <option  value="<%= s.getS_name()%>"><%= s.getS_name()%></option>
                
                                  <% } %>
                
                            </select> 
                            <input type="submit" value="Submit">
                         
                         </form>
    <% } %> 
                     
                     </td>
             
               
 
              </tr>
           
           
           
         </table>
         
         </div>
     
  
  </div>
</body>
</html>