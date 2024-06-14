<%@page import="java.util.List"%>
<%@page import="com.jee.beans.Document"%>
<%@page import="com.jee.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gerer les documents d'un utilisateur</title>
    <link rel="stylesheet" href="css/voirDocsUser.css">
    
</head>
<body>
    <header>
        <h2>Liste des documents de : <%= (request.getAttribute("username") != null) ? request.getAttribute("username") : "N/A" %></h2>
    </header>
    
    <main>
        <% 
            List<Document> ld = (List<Document>)request.getAttribute("ld");
            if(ld != null && !ld.isEmpty()) {
        %>
        <table border="2">
            <thead>
                <tr>
                	<th>Id</th>
                    <th>Title</th>
                    <th>Type</th>
                    <th>Path</th>
                    <th>Author</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for(int i = 0; i < ld.size(); i++) {
                        Document doc = ld.get(i);
                        int id = doc.getId();
                        String title = (doc.getTitle() != null) ? doc.getTitle() : "N/A";
                        String path = (doc.getPath() != null) ? doc.getPath() : "N/A";                        
                        String type = (doc.getType() != null) ? doc.getType() : "N/A";
                        String author = (doc.getAuthor() != null) ? doc.getAuthor() : "N/A";
                 %>
                <tr>
                	<td><%= id %></td>
                    <td><%= title %></td>
                    <td><%= type %></td>
                    <td><%= path %></td>   
                    <td><%= author %></td>
                    <td>                        
                        <form action="editerDoc.do" method="get">
                            <input type="hidden" name="id" value="<%=id%>">
                    	 	<input type="hidden" name="username" value="<%=doc.getUser().getUsername()%>">
	                        <button>Editer ce document</button>                		
                    	</form>
                    	
                    	<form action="supprimerDoc.do" method="get">
                    		<input type="hidden" name="id" value="<%=id%>">
                    		<input type="hidden" name="username" value="<%=doc.getUser().getUsername()%>">
	                        <button>Supprimer ce document</button>                		
                    	</form>
                    	
                    	<form action="afficherDoc.do" method="get">
	                        <button type="submit">Afficher contenu</button> 
	                        <input type="hidden" name="path" value="<%=doc.getPath()%>">
                    	</form>                     
                    </td>
                </tr>
                <% 
                    }
                 %>
            </tbody>
        </table>
       
        <% } else { %>
        <p>Aucun document trouvé.</p>
        <% } %>
    </main>
    
    <footer>
        <p>&copy; 2024 - Gestion des Documents</p>
    </footer>
</body>
</html>
