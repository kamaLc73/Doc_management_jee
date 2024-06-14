package com.jee.dao;

import java.util.List;

import com.jee.beans.Document;
import com.jee.beans.User;

public interface UserDao {
	public int insert(User u);
	public User select(String nom);
	public List<User> selectAll();
	public int delete(String nom);
	public int update(String[] values, String nom);
}
