<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %>
    <%@ page import="com.simplilearn.project.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Choose class name</title>
<link  type="text/css" rel="stylesheet" href="css/style.css">
</head>


<%
//Get the classes from the request object (sent by the servlet)
List<ClassDetails> theclasses = (List<ClassDetails>)request.getAttribute("CLASS_LIST");
%>


<body>

  <div id="wrapper">

     <div id="header">
          <h2>Choose Class whose Report you want to generate</h2>
     </div>
  </div>
  
  
  <div id="container">
  
      <div id="content">
         
           
           <form action="classes" method="get">
           
              
            <select name="className">
           
                <% for(ClassDetails cd : theclasses){%>
                
                <option value="<%= cd.getName()%>"><%= cd.getName()%></option>
                
                
                <% } %>
           </select>
           
           <input type="hidden" name="command" value="LIST">
           <input type="submit" value="Submit">
           
           
           </form>      
           
          
      </div>
  
  </div>
  
  
  
</body>
</html>