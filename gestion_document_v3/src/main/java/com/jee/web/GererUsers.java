package com.jee.web;

import com.jee.business.Facade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GererUsers extends Action {

	public GererUsers(Facade facade) {
		super(facade);
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setAttribute("lu", facade.listerUsers());
			return "/views/gererUsers.jsp";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

}
