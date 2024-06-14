package com.jee.web;

import com.jee.business.Facade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

abstract public class Action {
	protected Facade facade;
	
	public Action(Facade Facade) {
		this.facade = Facade;
	}
	abstract String execute(HttpServletRequest req, HttpServletResponse resp);
}
