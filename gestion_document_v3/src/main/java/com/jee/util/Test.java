package com.jee.util;

import com.jee.beans.Document;
import com.jee.beans.User;
import com.jee.business.DocManagerImpl;
import com.jee.business.Facade;
import com.jee.business.UserManagerImpl;

public class Test {

	public static void main(String[] args) {
//		Docmanagerimpl doc =new Docmanagerimpl();
		UserManagerImpl us = new UserManagerImpl();
//		Facade f = new Facade();
//		  User user = new User("john_doe", "password123", "user");
//		  User user1 = new User("walid", "walid", "admin");
//		  f.getUm().add(user1);
//		  Document document = new Document(1, "HAHA", "PDF", "/chemin/vers/document", "MOI", new User("wiwi","caca", "user"));
//		  f.getDm().add(document);
		for (User u : us.getAll()) {
			System.out.println(u.toString());
		} 
	}

}
