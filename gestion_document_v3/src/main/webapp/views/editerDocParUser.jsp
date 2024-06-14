<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Gestion des documents</title>
    <link rel="stylesheet" href="css/editerDocParUser.css">
    
</head>
<body>
    <header>
        <h2>Modifier un document</h2>
        
    </header>
    
    <main>
        <form action="modificationDoc.do" method="post">
            <!-- Ajoutez ici les champs que vous souhaitez modifier -->
            <label for="nouveauTitre">Nouveau titre:</label>
            <input type="text" id="nouveauTitre" name="nouveauTitre">
            <br>            
            <label for="nouveauAuthor">Nouveau Author:</label>
            <input type="text" id="nouveauAuthor" name="nouveauAuthor">
            <br>
            <input type="submit" value="Modifier">
            <input type="hidden" name="id" value="<%=request.getAttribute("id")%>">
            <input type="hidden" name="username" value="<%=request.getAttribute("username")%>">
        </form>
    </main>
    
    <footer>
        <p>&copy; 2024 - Gestion des Documents</p>
    </footer>
</body>
</html>