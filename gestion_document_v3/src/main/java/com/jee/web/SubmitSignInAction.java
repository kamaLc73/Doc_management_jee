package com.jee.web;

import com.jee.beans.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SubmitSignInAction extends Action {

	public SubmitSignInAction(com.jee.business.Facade Facade) {
		super(Facade);
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			
			String username = req.getParameter("username");
			
			for (User u : facade.listerUsers()) {
				if(u.getUsername().equals(username)) {
					req.setAttribute("message", "Ce nom d'utilisateur existe deja choisissez un autre.");
					return "views/signIn.jsp";
				}
			}
			
			facade.ajouterUser(new User(username, req.getParameter("pass"), req.getParameter("userType")));
			req.setAttribute("message", "Utilisateur crée avec succès!");
			return "/views/loginResult.jsp";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
