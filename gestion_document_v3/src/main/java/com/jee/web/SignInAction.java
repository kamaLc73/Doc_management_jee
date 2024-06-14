package com.jee.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignInAction extends Action {
	
	public SignInAction(com.jee.business.Facade Facade) {
		super(Facade);
	}

	@Override
	String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			return "/views/signIn.jsp";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Not executed";
		}
	}
}
