package com.jee.web;

import java.util.List;

import com.jee.beans.Document;
import com.jee.beans.User;
import com.jee.business.Facade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ValiderEdition extends Action {

	public ValiderEdition(Facade facade) {
		super(facade);
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String username= req.getParameter("username");
			
			for (User users : facade.listerUsers()) {
				if(users.getUsername().equals(username)) {
					req.setAttribute("message", "Ce nom d'utilisateur existe déja choisissez un autre.");
					return "views/editerUser.jsp";
				}
			}
			
			String u = req.getParameter("user1");
			List<Document> ld = facade.listerDocs(u);

			
			String password= req.getParameter("password");
			String type= req.getParameter("type");
			System.out.println(type);
			User user2 = new User(username, password, type);
			System.out.println("restart");
			
			for (Document d : ld) {
				String[] values = {d.getTitle(), d.getType(), d.getPath(), d.getAuthor(), username};
				facade.modifierDoc(values, d.getId());				
			}
			
			facade.ajouterUser(user2);
			facade.supprimerUser(u);
			
			req.setAttribute("lu", facade.listerUsers());
			return "/views/gererUsers.jsp";
		} catch (Exception e) {
			System.out.println(e.getMessage());		
			return "muchkila";
		}
	}

}
