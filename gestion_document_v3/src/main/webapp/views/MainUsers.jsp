<%@page import="java.util.List"%>
<%@page import="com.jee.beans.Document"%>
<%@page import="com.jee.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main user</title>
   	<link rel="stylesheet" href="css/MainUsers.css">
    
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
                    <th>Title</th>
                    <th>Type</th>
                    <th>Author</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for(int i = 0; i < ld.size(); i++) {
                        Document doc = ld.get(i);
                        String title = (doc.getTitle() != null) ? doc.getTitle() : "N/A";
                        String type = (doc.getType() != null) ? doc.getType() : "N/A";
                        String author = (doc.getAuthor() != null) ? doc.getAuthor() : "N/A";
                 %>
                <tr>
                    <td><%= title %></td>
                    <td><%= type %></td>
                    <td><%= author %></td>
                    <td>
                        <form action="editerDocParUser.do" method="get">
	                        <button>Editer ce document</button>
	                        <input type="hidden" name="id" value="<%=doc.getId()%>">
	                        <input type="hidden" name="username" value="<%=doc.getUser().getUsername()%>">
                    	</form>
                    	
                    	<form action="supprimerDocParUser.do" method="get">
	                        <button>Supprimer ce document</button>
	                        <input type="hidden" name="id" value="<%=doc.getId()%>">
	                        <input type="hidden" name="username" value="<%=doc.getUser().getUsername()%>">
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
        <p>Aucun document trouvÃ©.</p>
        <% } %>
        
        <%if(request.getAttribute("message")!= null){ %>    	
		        <h3 style="color:green;"><%=request.getAttribute("message") %></h3>
		<%} %>
   		<div>
           	<form action="ajouterDocParUser.do" method="get">
		        <input type="hidden" name="username" value="<%=request.getAttribute("username")%>">
           		<input type="submit" value="Ajouter un document!">       		
        	</form>
        </div>
    </main>
    
    <footer>
        <p>&copy; 2024 - Gestion des Documents</p>
    </footer>
</body>
</html>