package com.jee.business;

import java.util.List;

import com.jee.beans.Document;


public interface DocManager {
	public int add(Document d);
	public Document get(int id);
	public List<Document> getAll(String s);
	public int remove(int id);
	public int update(String[] values, int id);
}
