package com.jee.business;

import java.util.List;

import com.jee.beans.User;
import com.jee.dao.UserDao;
import com.jee.dao.UserDaoImpl;

public class UserManagerImpl implements UserManager {
	
	private UserDao ud;
	public UserManagerImpl() {
		ud= new UserDaoImpl();
	}
	
	public int add(User u) {
    	System.out.println("ADD USER BUSINESS -------------->");
		return ud.insert(u);
	}

	@Override
	public User get(String username) {
		System.out.println("GET USER BUSINESS -------------->");
		return ud.select(username);
	}

	@Override
	public List<User> getAll() {
		System.out.println("GET_ALL USER BUSINESS -------------->");
		return ud.selectAll();
	}

	@Override
	public int remove(String username) {
		System.out.println("DELETE USER BUSINESS -------------->");
		return ud.delete(username);
	}

	@Override
	public int update(String[] values, String username) {
		System.out.println("UPDATE USER BUSINESS -------------->");
		return ud.update(values, username);
	}

}
