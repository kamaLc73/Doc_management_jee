package com.jee.web;

import com.jee.business.Facade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DocAjouterSucces extends Action {

	public DocAjouterSucces(Facade Facade) {
		super(Facade);
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String username = req.getParameter("username");
			System.out.println(username);
			req.setAttribute("username", username);
			req.setAttribute("ld", facade.listerDocs(username));
			return "/views/MainUsers.jsp";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "muchkila";
		}	
	}
}
