package com.jee.web;

import java.util.List;

import com.jee.beans.Document;
import com.jee.beans.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditerUser extends Action {

	public EditerUser(com.jee.business.Facade Facade) {
		super(Facade);
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String u = req.getParameter("username");	
			req.setAttribute("username1", u);
			return "/views/editerUser.jsp";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
