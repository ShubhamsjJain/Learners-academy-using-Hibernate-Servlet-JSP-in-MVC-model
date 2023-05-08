<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.simplilearn.project.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Subject Form</title>
<link  type="text/css" rel="stylesheet" href="css/style.css">
<link  type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<%
//Get the classes from the request object (sent by the servlet)
List<ClassDetails> theclasses = (List<ClassDetails>)request.getAttribute("CLASS_LIST");
%>

<body>

<div id="wrapper">

     <div id="header">
          <h2>Add Subject with class details</h2>
     
  
  </div>
     
  </div>
  
         <div id="container">
         
         <h3>Add new Subject or allocate an existing subject to new class</h3>
           
           <form action="subjects" method="get">
           
             <table>
              <tbody>
             <tr>
                <td><label>Enter Subject Name:</label></td>
                <td><input type ="text" name="subject"></td>
             </tr>
           
           
             <tr>
             
             <!-- use both id and name in select tag to put all id's in array with name class[] -->
             
                <td><label>Class 1:</label></td> 
                
                <td><select id="class1" name="class[]">
           
                       <% for(ClassDetails cd : theclasses){%>
                
                              <option value="<%= cd.getName()%>"><%= cd.getName()%></option>
                
                       <% } %>
                
                    </select>
                </td>
             </tr>
           
           
             
           
           <tr>
              
               <td><input type="hidden" name="command" value="ADD"></td>
                 
           </tr>
           
           <tr>
           <td><label></label></td>
           <td><input type="submit" value="Submit"></td>
           </tr>
           
           
             </tbody>
           </table>
           
           
           </form>      
           
       </div>   
     
</body>
</html>