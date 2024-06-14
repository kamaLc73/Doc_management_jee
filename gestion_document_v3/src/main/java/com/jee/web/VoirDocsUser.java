package com.jee.web;

import com.jee.business.Facade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VoirDocsUser extends Action {

	public VoirDocsUser(Facade facade) {
		super(facade);
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String username =req.getParameter("username");
			req.setAttribute("ld", facade.listerDocs(username));
			req.setAttribute("username", username);
			return "/views/voirDocsUser.jsp";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

}
