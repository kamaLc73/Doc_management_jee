package com.jee.dao;

import java.util.List;

import com.jee.beans.Document;

public interface DocumentDao {
	public int insert(Document d);
	public Document select(int id);
	public List<Document> selectAll(String s);
	public int delete(int id);
	public int update(String[] values, int id);
}
