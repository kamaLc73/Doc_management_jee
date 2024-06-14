<%@page import="com.jee.business.Facade"%>
<%@page import="java.util.List"%>
<%@page import="com.jee.beans.Document"%>
<%@page import="com.jee.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Gestion des utilisateurs</title>	    
	    <link rel="stylesheet" href="css/gererUsers.css">
	    
	</head>
	<body>
	    <header>
	        <h2>Liste des utilisateurs</h2>
	    </header>
	    
	    <main>
	        <% 
	            List<User> lu = (List<User>)request.getAttribute("lu");
	        	Facade f = new Facade();
	      		int count = 0;
	            if(lu != null && !lu.isEmpty()) {
	        %>
	        <table border="2">
	            <thead>
	                <tr>
	                    <th>Nom d'utilisateur</th>
	                    <th>Mot de passe</th>
	                    <th>Type</th>
	                    <th>Nombre de documents</th>
	                    <th>Action</th>
	                </tr>
	            </thead>
	            <tbody>
	                <% 
	                    for(int i = 0; i < lu.size(); i++) {
	                       	User u = lu.get(i);
	                       	
	    		 			String username = u.getUsername() != null ? u.getUsername() : "N/A";
	                        String pass = u.getPassword() != null ? u.getPassword() : "N/A";
	                        String type = (u.getType()) != null ? u.getType() : "N/A";
	                        for(Document d : f.listerDocs(u.getUsername())){
								count++;                     	
	                        }
	                 %>
	                <tr>
	                    <td><%= username %></td>
	                    <td><%= pass %></td>
	                    <td><%= type %></td>
	                    <td><%= count %></td>
	                    <td>
	                    	<form action="editerUser.do" method="get">
		                        <input type="hidden" name="username" value="<%=username%>">
		                        <button>Editer utilsateur</button>                		
	                    	</form>
	                    	
	                    	<form action="supprimerUser.do" method="get">
		                        <input type="hidden" name="username" value="<%=username%>">
		                        <button>Supprimer utilsateur</button>                		
	                    	</form>
	                    	
	                    	<form action="voirDocsUser.do" method="get">
								<input type="hidden" name="username" value="<%=username%>">
		                        <button>Voir ses documents</button>                        		
	                    	</form>               
	                    </td>
	                </tr>
	               	<% 
	                   count = 0;
	                   }
	                %>
	            </tbody>
	        </table>
	        <% } else { %>
	        <p>Aucun utilisateur trouvé.</p>
	        <% } %>
	    </main>
	    
	    <footer>
	        <p>&copy; 2024 - Gestion des utilisateurs</p>
	    </footer>
	</body>
</html>
