package com.jee.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditerDoc extends Action {

	public EditerDoc(com.jee.business.Facade Facade) {
		super(Facade);
		
	}

	String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int id =Integer.parseInt(req.getParameter("id"));
			req.setAttribute("id", id);		
			return "/views/EditerDoc.jsp";
		} catch (Exception e) {
			
		}
		return null;
	}

}
