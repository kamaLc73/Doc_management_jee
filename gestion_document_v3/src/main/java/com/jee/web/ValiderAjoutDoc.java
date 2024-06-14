package com.jee.web;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.jee.beans.*;
import com.jee.business.Facade;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@MultipartConfig
public class ValiderAjoutDoc extends Action {

	
	public ValiderAjoutDoc(Facade facade) {
		super(facade);
		
	}

	String execute(HttpServletRequest req, HttpServletResponse resp) {
	    try {
	        System.out.println("Début de l'exécution de la méthode execute.");

	        String uploadDirectory = "C:\\Users\\kamal\\Desktop\\wk\\gestion_document_v3\\src\\main\\webapp\\documents";
	        System.out.println("Chemin du répertoire de destination : " + uploadDirectory);

	        Part filePart = req.getPart("file");
	        System.out.println("Fichier téléchargé récupéré depuis la requête.");

	        String fileName = req.getParameter("title");
	        System.out.println("Nom du fichier : " + fileName);

	        String type = req.getParameter("type");
	        System.out.println("Type du fichier : " + type);

			String destination = uploadDirectory + "\\" + type + "\\" + fileName + "."+ type;
	        System.out.println("Chemin complet du fichier de destination : " + destination);

	        try (InputStream inputStream = filePart.getInputStream();
    			FileOutputStream outputStream = new FileOutputStream(destination)) {
	        	System.out.println("Début de l'écriture du fichier.");

	            byte[] buffer = new byte[4096];
	            int bytesRead;
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);
	            }

	            System.out.println("Fin de l'écriture du fichier.");
	        }

	        resp.getWriter().println("Le fichier a été téléchargé avec succès.");
	        System.out.println("Le fichier a été téléchargé avec succès.");
	        String username = req.getParameter("username");
	        req.setAttribute("username", username);
	        
	        String filePath = "documents/" + type + "/" + fileName + "." + type;
	        String author = req.getParameter("author");
	        User user = facade.listerUser(username);
	        facade.ajouterDoc(new Document(0, fileName, type, filePath, author, user));
	        return "views/docAjouterSucces.jsp";
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        return "muchkil";
	    }
	}
}
