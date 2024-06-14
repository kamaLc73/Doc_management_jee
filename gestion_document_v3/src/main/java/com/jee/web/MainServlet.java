package com.jee.web;

import jakarta.servlet.annotation.MultipartConfig;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.jee.business.Facade;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@MultipartConfig
public class MainServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private Facade f;
	private Map<String, Action> actions;
			
	public void init() throws ServletException {
		f = new Facade();
		actions = new HashMap<>();
		actions.put("login", new LoginAction(f));
		actions.put("signIn", new SignInAction(f));
		actions.put("submitSignIn", new SubmitSignInAction(f));
		actions.put("gererUsers", new GererUsers(f));
		actions.put("editerUser", new EditerUser(f));
		actions.put("voirDocsUser", new VoirDocsUser(f));
		actions.put("supprimerUser", new SupprimerUser(f));
		actions.put("supprimerDoc", new SupprimerDoc(f));
		actions.put("valideredition", new ValiderEdition(f));
		actions.put("editerDoc", new EditerDoc(f));
		actions.put("ValiderDoc", new ValiderDoc(f));
		actions.put("supprimerDocParUser",new SupprimerDocParUser(f));
	    actions.put("editerDocParUser",new EditererDocParUser(f));
	    actions.put("modificationDoc",new ModificationDoc(f));
	    actions.put("ajouterDocParUser",new AjouterDocParUser(f));
	    actions.put("validerAjout",new ValiderAjoutDoc(f));
	    actions.put("afficherDoc",new AfficherDoc(f));
	    actions.put("docAjouterSucces", new DocAjouterSucces(f));     
	 }
	 
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		int x = uri.lastIndexOf('/');
		int y = uri.lastIndexOf(".do");
		String key = uri.substring(x+1, y);
		System.out.println("Key : " + key);
		Action action = actions.get(key);
		System.out.println("Action : " + action.getClass().getSimpleName());
		String view = action.execute(req, resp);
		req.getRequestDispatcher(view).forward(req, resp);
	 }
	 
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
	 }

}
