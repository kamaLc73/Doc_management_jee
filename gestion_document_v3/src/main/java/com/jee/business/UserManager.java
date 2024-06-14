package com.jee.business;

import java.util.List;

import com.jee.beans.User;

public interface UserManager {
	public int add(User u);
	public User get(String username);
	public List<User> getAll();
	public int remove(String username);
	public int update(String[] values, String username);
}
