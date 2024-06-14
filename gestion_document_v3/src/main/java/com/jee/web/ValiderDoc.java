package com.jee.web;

import com.jee.beans.User;
import com.jee.business.Facade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ValiderDoc extends Action {

	public ValiderDoc(Facade facade) {
		super(facade);
		
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
			try {
				String titre= req.getParameter("title");
				String type= req.getParameter("type");
				String path= req.getParameter("path");
				String auteur= req.getParameter("author");
				String username= req.getParameter("username");
				for (User u : facade.listerUsers()) {
					if(username.equals(u.getUsername())) {
						String[] values= {titre,type,path,auteur,username};
						facade.modifierDoc(values, Integer.parseInt(req.getParameter("id")));
						req.setAttribute("message", "Document modifie avec succes!");
						req.setAttribute("ld", facade.listerDocs(""));
						return "/views/MainAdmin.jsp";
					}	
				}
				req.setAttribute("message", "l'utilisateur souhaité n'existe pas! Entrez un valide utilisateur ou créez le!");
				req.setAttribute("ld", facade.listerDocs(""));
				return "/views/MainAdmin.jsp";
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return null;
	}

}
