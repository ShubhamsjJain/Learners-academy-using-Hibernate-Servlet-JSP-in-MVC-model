<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.simplilearn.project.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students list</title>
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
              <th>Student List</th>
              <th>Teacher List</th>
              <th>Subjects List</th>
              <th>Action</th>
              
           </tr>
           
           
                
               <tr>
                     <td><%= String.valueOf(classdetails.getID())%></td>
                     
                     <td><ul>
                     
                     <% if(classdetails.getStu() != null && !classdetails.getStu().isEmpty()){ %>
                     <% for(Student stu: classdetails.getStu()) {%>
                     
                     <li><%= stu.getName()%></li>
                      
                     <% }%>
                     
                     <% }else{ %>
                     
                         None
                     
                     <% } %>
                     
    <% } %>                 
                     
                     </ul></td>
                     <td></td>
                     <td></td>
             
               
 
              </tr>
           
           
           
         </table>
         
         </div>
     
  
  </div>
</body>
</html>