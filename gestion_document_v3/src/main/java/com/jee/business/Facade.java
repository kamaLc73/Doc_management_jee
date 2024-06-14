package com.jee.business;

import java.util.List;

import com.jee.beans.Document;
import com.jee.beans.User;

public class Facade {
	
     private DocManagerImpl doc;
     private UserManagerImpl us;

     public Facade() {
         doc = new DocManagerImpl();
         us = new UserManagerImpl();
     }
  
     public int ajouterDoc(Document d) {
         return doc.add(d);
     }

     public Document listerDoc(int id) {
        return doc.get(id);
     }

     public List<Document> listerDocs(String s) {
        return doc.getAll(s);
     }

     public int supprimerDoc(int id) {
        return doc.remove(id);
    }

     public int modifierDoc(String[] values, int id) {
        return doc.update(values, id);
    }

     public int ajouterUser(User u) {
        return us.add(u);
     }

     public User listerUser(String username) {
        return us.get(username);
    }

     public List<User> listerUsers() {
        return us.getAll();
     }

     public int supprimerUser(String username) {
        return us.remove(username);
     }

     public int modifierUser(String[] values, String username) {
        return us.update(values, username);
    }
}