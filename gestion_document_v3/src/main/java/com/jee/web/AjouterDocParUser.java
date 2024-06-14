package com.jee.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AjouterDocParUser extends Action {

	public AjouterDocParUser(com.jee.business.Facade Facade) {
		super(Facade);
		
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setAttribute("username", req.getParameter("username"));
			return "views/validationAjout.jsp";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
