<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.simplilearn.project.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>

<%

//Get the students from the request object (sent by the servlet)

List<Student> theStudents = (List<Student>)request.getAttribute("STUDENT_LIST");
%>
<body>

  <div id="wrapper">

     <div id="header">
          <h2>Learners Academy</h2>
     </div>
  </div>
  
  
  <div id="container">
  
      <div id="content">
      
         
         
         <table width=100%>
         
           <tr>
           
              <th>Student ID</th>
              <th>Student Name</th>
              <th>Student E-Mail</th>
              <th>Student City</th>
              <th>Student class</th>
              <th>Action</th>
              
           </tr>
           
           <% for(Student st: theStudents) {%>
                
               <tr>
                     <td><%= String.valueOf(st.getID())%></td>
                     <td><%= st.getName()%></td>
                     <td><%= st.getE_mail()%></td>
                     <td><%= st.getCity()%></td>
             
               <!-- Print class for this student -->
               
                            <% ClassDetails classdetails = st.getClassdetails(); %>
            		   
            		           
                
                     <td><%= classdetails.getName()%> </td>
 
              </tr>
           
           <% } %>
           
         </table>
         
         
      </div>
  
  </div>
</body>
</html>