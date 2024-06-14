<%@page import="java.util.List"%>
<%@page import="com.jee.beans.Document"%>
<%@page import="com.jee.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main admin</title>
    <link rel="stylesheet" href="css/MainAdmin.css">
  
</head>
<body>
    <header>
        <h2>Liste des documents</h2>
    </header>

    <main>
        <% 
            List<Document> ld = (List<Document>)request.getAttribute("ld");
            if(ld != null && !ld.isEmpty()) {
        %>
        <table border="2">
            <thead>
                <tr>
                    <th>Id Document</th>
                    <th>Title</th>
                    <th>Type</th>
                    <th>Path</th>
                    <th>Author</th>
                    <th>Username</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for(int i = 0; i < ld.size(); i++) {
                        Document doc = ld.get(i);
                        String id = Integer.toString(doc.getId()); // Convertir l'ID en String
                        String title = (doc.getTitle() != null) ? doc.getTitle() : "N/A";
                        String type = (doc.getType() != null) ? doc.getType() : "N/A";
                        String path = (doc.getPath() != null) ? doc.getPath() : "N/A";
                        String author = (doc.getAuthor() != null) ? doc.getAuthor() : "N/A";
                        User user = doc.getUser();
                        String username = (user != null && user.getUsername() != null) ? user.getUsername() : "N/A";
                 %>
                <tr>
                    <td><%= id %></td>
                    <td><%= title %></td>
                    <td><%= type %></td>
                    <td><%= path %></td> 
                    <td><%= author %></td>
                    <td><%= username %></td>
                    
                </tr>
                <% 
                    }
                 %>
            </tbody>
        </table>
         <div>
         <% if(request.getAttribute("message")!=null){ %>
        	 <h4 id="p-alert"><%=request.getAttribute("message") %></h4>
        <%} %> 
			
		</div>
        <% } else { %>
        <p>Aucun document trouvé.</p>
        <% } %>
        
        <br>
        
        <div>
        	<form action="gererUsers.do" method="get">
        		<input type="submit" value="Gerer les utilisateurs">       		
        	</form>
        </div>
        
    </main>
    
    <footer>
        <p>&copy; 2024 - Gestion des Documents</p>
    </footer>
</body>
</html>
