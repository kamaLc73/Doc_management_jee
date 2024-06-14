package com.jee.business;

import java.util.List;

import com.jee.beans.Document;
import com.jee.dao.DocumentDao;
import com.jee.dao.DocumentDaoImpl;

public class DocManagerImpl implements DocManager {
	
	private DocumentDao doc;
	
	public DocManagerImpl() {
		doc = new DocumentDaoImpl();
	}
	
	public int add(Document d) {
    	System.out.println("ADD DOCUMENT BUSINESS -------------->");
		return doc.insert(d);	
	}

	@Override
	public Document get(int id) {
    	System.out.println("GET DOCUMENT BUSINESS -------------->");
		return doc.select(id);
	}

	@Override
	public List<Document> getAll(String s) {
    	System.out.println("GET_ALL DOCUMENT BUSINESS -------------->"); 
		return doc.selectAll(s);
	}

	@Override
	public int remove(int id) {
    	System.out.println("DELETE DOCUMENT BUSINESS -------------->");
		return doc.delete(id);	
	}

	@Override
	public int update(String[] values, int id) {
    	System.out.println("UPDATE DOCUMENT BUSINESS -------------->");
		return doc.update(values, id);
	}
}
