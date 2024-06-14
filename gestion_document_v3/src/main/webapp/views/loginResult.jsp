<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Stages</title>
</head>
<body>
    <%@include file="../index.html" %>
    <br>
    <br>
    <% if (request.getAttribute("invalidLogin") != null) { %>
			<script>
	            var a = document.getElementById('p-alert');
	            a.textContent = "Nom d'utilisateur ou mot de passe incorrect!";
	            a.style.textAlign = 'center';
	            a.style.fontSize = '1.2em'; 
	            a.style.color = 'red';
	        </script>
    <% } %>
    
    <% if (request.getAttribute("message") != null) { %>
			<script>
	            var a = document.getElementById('p-alert');
	            a.textContent = "<%=request.getAttribute("message")%>";
	            a.style.textAlign = 'center';
	            a.style.fontSize = '1.2em'; 
	            a.style.color = 'green';
	        </script>
    <% } %>
</body>
</html>
