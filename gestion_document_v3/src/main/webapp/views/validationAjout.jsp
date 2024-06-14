<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un document</title>
    <link rel="stylesheet" href="css/validationAjout.css">
    
</head>
<body>
    <h2>Ajouter un document</h2>
    <form action="validerAjout.do" method="post" enctype="multipart/form-data">
        <label for="title">Titre:</label><br>
        <input type="text" id="title" name="title"><br>
        
        <label for="type">Type:</label><br>
        <select id="type" name="type">
            <option value="csv">csv</option>
            <option value="docx">docx</option>
            <option value="jpeg">jpeg</option>
            <option value="jpg">jpg</option>
            <option value="mkv">mkv</option>
            <option value="mp4">mp4</option>
            <option value="pdf">pdf</option>
            <option value="png">png</option>
            <option value="pptx">pptx</option>
            <option value="txt">txt</option>
            <option value="wav">wav</option>
            <option value="xlsx">xlsx</option>       
        </select><br>
        
        <label for="file">Sélectionnez un fichier:</label><br>
        <input type="file" id="file" name="file"><br>
        
        <label for="author">Auteur:</label><br>
        <input type="text" id="author" name="author"><br>

        <input type="hidden" id="username" name="username" value="<%= (request.getAttribute("username") != null) ? request.getAttribute("username") : "N/A" %>"><br> 
        
        <input type="submit" value="Ajouter">
    </form>
</body>
</html>
