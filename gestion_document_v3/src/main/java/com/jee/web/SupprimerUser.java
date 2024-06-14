package com.jee.web;

import java.util.List;

import com.jee.beans.Document;
import com.jee.business.Facade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SupprimerUser extends Action {

	public SupprimerUser(Facade facade) {
		super(facade);
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String username = req.getParameter("username");
			List<Document> ldu = facade.listerDocs(username);
			for (Document d : ldu) {
				facade.supprimerDoc(d.getId());
			}
			facade.supprimerUser(username);
			req.setAttribute("lu", facade.listerUsers());
			return "/views/gererUsers.jsp";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
