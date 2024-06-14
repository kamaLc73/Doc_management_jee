package com.jee.web;

import jakarta.servlet.http.HttpServletRequest;

import com.jee.beans.Document;
import com.jee.business.Facade;
import jakarta.servlet.http.HttpServletResponse;

public class AfficherDoc extends Action {

	public AfficherDoc(Facade facade) {
		super(facade);
	}

	String execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String path = req.getParameter("path");	
			return path;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
   }
}
