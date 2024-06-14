<%@page import="java.util.List"%>
<%@page import="com.jee.beans.Document"%>
<%@page import="com.jee.beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit User</title>
		<link rel="stylesheet" href="css/editerUser.css">
		
	</head>
	<body>
		<h2>Editer utilisateur</h2>
	    <form action="valideredition.do" method="post">
	       	<% 
	            List<Document> ld = (List<Document>)request.getAttribute("ld");
	            String u= (String)request.getAttribute("username1");
	        %>
	        <div>
	            <label for="username">Username:</label>
	            <input type="text" id="username" name="username" value="" required>
	        </div>
	        <div>
	            <label for="password">Password:</label>
	            <input type="password" id="password" name="password" value="" required>
	        </div>
	        <div>
	            <label for="type">Type:</label>
	            <select id="type" name="type" required>
	                <option value="admin" >admin</option>
	                <option value="user" >user</option>
	            </select>
	        </div>
	        <div>
	            <button type="submit">Update User</button>
	            <input type="hidden" name="ld" value="<%=ld%>">
	            <input type="hidden" name="user1" value="<%=u%>">          
	        </div>
	        
	         <%if(request.getAttribute("message")!= null){ %>    	
			        <h4 style="color:red;"><%=request.getAttribute("message") %></h4>
			 <%} %>
	    </form>
	</body>
</html>