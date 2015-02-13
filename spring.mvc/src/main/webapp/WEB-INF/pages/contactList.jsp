<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html lang="en">
  <head>
    <meta charset="utf-8">
       
<title>Contact List</title>

 
   </head>
    <body data-spy="scroll">
                 
  <header>
  	<span style="text-decoration: underline;">Welcome To Contact List Page</span>
  	<span><b><a href="home" style="float: right;text-decoration: underline;">Home</a></b></span>
  
  </header>

 
    <div id="services" class="container">
    <H1 style="color: blue;text-decoration: underline;text-shadow: black;text-align: center">Contact List</H1>
<div class="row" align="center">
              <table border="1" style="width: 100%;height: 100%">
              <tr>
	              <th style="text-decoration: underline;color: green;">Name</th>
	              <th style="text-decoration: underline;color: green;">Email</th>
	              <th style="text-decoration: underline;color: green;">Number</th>
	              <th style="text-decoration: underline;color: green;">Address</th>
              </tr>
              
            <c:forEach var="contact" items="${contactList}" varStatus="count">
            	<tr>
            		<td> ${contact.name} </td>
            		<td> ${contact.email} </td>
            		<td> ${contact.contactNumber} </td>
            		<td> ${contact.address} </td>
            	
            	</tr>
              </c:forEach>
              </table>
       </div><!-- ITEM END -->
       
 

               
      </div>
    
   
   
</body>
</html>