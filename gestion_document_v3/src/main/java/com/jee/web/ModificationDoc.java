package com.jee.web;

import com.jee.beans.Document;
import com.jee.business.Facade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificationDoc extends Action {

	public ModificationDoc(Facade facade) {
		super(facade);
	}

	String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			Document d = facade.listerDoc(id);
			String username =req.getParameter("username");
			
			String title =req.getParameter("nouveauTitre");
			String Author =req.getParameter("nouveauAuthor");
			
			String[] s = {title, d.getType(), d.getPath(), Author, facade.listerUser(username).getUsername()};
			facade.modifierDoc(s, id);
			req.setAttribute("ld", facade.listerDocs(username));	
			req.setAttribute("username", username);
			req.setAttribute("message", "Document modifié avec succès!");
			return "/views/MainUsers.jsp";
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}	
	}
}


