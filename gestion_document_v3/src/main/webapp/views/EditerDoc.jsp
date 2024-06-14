<!DOCTYPE html>
<%@page import="com.jee.business.Facade"%>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Information Document</title>
    <link rel="stylesheet" href="css/EditerDoc.css">
    
</head>
<body>
		<%
		int id=(int)request.getAttribute("id");
		Facade f = new Facade();
		%>
    <h2>Editer les information du Document</h2>
    <form action="ValiderDoc.do" method="post">
        
        
        <label for="title">Title:</label><br>
        <input type="text" id="title" name="title"><br>
        
        <label for="author">Author:</label><br>
        <input type="text" id="author" name="author"><br>
       
        <label for="username">User:</label><br>
        <input type="text" id="username" name="username"><br>
        
        <button type="submit" >Valider</button>
        <input type="hidden" name="id" value="<%=id%>">
        <input type="hidden" name="type" value="<%=f.listerDoc(id).getType()%>">
        <input type="hidden" name="path" value="<%=f.listerDoc(id).getPath()%>">
        
    </form>
</body>
</html>