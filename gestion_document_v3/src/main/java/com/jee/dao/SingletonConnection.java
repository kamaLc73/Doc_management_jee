package com.jee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static SingletonConnection instance;
    private Connection cnx;
    private final String url = "jdbc:mysql://localhost/gestion_doc"; 
    private final String username = "root"; 
    private final String password = ""; 

    private SingletonConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to DB !");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized SingletonConnection getInstance() {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}
