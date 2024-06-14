package com.jee.web;

import com.jee.business.Facade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditererDocParUser extends Action {
	
	public EditererDocParUser(Facade facade) {
		super(facade);
	}

	String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			req.setAttribute("id", id);
			
			String username =req.getParameter("username");
			req.setAttribute("username", username);
			req.setAttribute("message", "Document modifié");
			return "/views/editerDocParUser.jsp";
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}	
	}
}
