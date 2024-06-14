package com.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jee.beans.Document;
import com.jee.beans.User;


public class DocumentDaoImpl implements DocumentDao {

    private Connection cnx;
    private UserDao us;
    
    public DocumentDaoImpl() {
        cnx = SingletonConnection.getInstance().getCnx();
        us = new UserDaoImpl();    
    }

    public int insert(Document document) {
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement("INSERT INTO document(title, type, path, author, username) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, document.getTitle());
            preparedStatement.setString(2, document.getType());
            preparedStatement.setString(3, document.getPath());
            preparedStatement.setString(4, document.getAuthor());
            preparedStatement.setString(5, document.getUser().getUsername());
        	System.out.println("ADD DOCUMENT DAO -------------->");
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Document select(int id) {
        Document document = null;
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement("SELECT * FROM document WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                document = new Document();
                document.setId(rs.getInt("id"));
                document.setTitle(rs.getString("title"));
                document.setType(rs.getString("type"));
                document.setPath(rs.getString("path"));
                document.setAuthor(rs.getString("author"));
                User user = new User();
                user=us.select( rs.getString("username")); 
                document.setUser(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	System.out.println("GET DOCUMENT DAO -------------->");
        return document;
    }

    public List<Document> selectAll(String s) {
    	String req = "";
        List<Document> documents = new ArrayList<>();
        try {
        	PreparedStatement preparedStatement = null;
        	if (s.equals("")) {
            	req = "SELECT * FROM document";
                preparedStatement = cnx.prepareStatement(req);
            	System.out.println("GET_ALL DEFAULT DOCUMENT DAO -------------->");
			} else {
	        	req= "SELECT * FROM document WHERE username = ?";
                preparedStatement = cnx.prepareStatement(req);
                preparedStatement.setString(1, s);
            	System.out.println("GET_ALL BY USERNAME DOCUMENT DAO -------------->");
			}	
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Document document = new Document();
                document.setId(rs.getInt("id"));
                document.setTitle(rs.getString("title"));
                document.setType(rs.getString("type"));
                document.setPath(rs.getString("path"));
                document.setAuthor(rs.getString("author"));
                User user = new User();
                user = us.select(rs.getString("username"));
                document.setUser(user);
                documents.add(document);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documents;
    }

    public int delete(int id) {
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement("DELETE FROM document WHERE id=?");
            preparedStatement.setInt(1, id);
        	System.out.println("DELETE DOCUMENT DAO -------------->");
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(String[] values, int id) {
        try {
            String sql = "UPDATE document SET title=?, type=?, path=?, author=?, username=? WHERE id=?";
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setString(1, values[0]);
            preparedStatement.setString(2, values[1]);
            preparedStatement.setString(3, values[2]);
            preparedStatement.setString(4, values[3]);
            preparedStatement.setString(5, values[4]);
            preparedStatement.setInt(6, id);
        	System.out.println("UPDATE DOCUMENT DAO -------------->");            
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
