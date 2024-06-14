package com.jee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jee.beans.Document;
import com.jee.beans.User;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl implements UserDao{
	private Connection connection;
	public UserDaoImpl() {
		 connection = SingletonConnection.getInstance().getCnx();
	}
    @Override
    public int insert(User user) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("INSERT INTO user (username, password, type) VALUES (?, ?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getType());
        	System.out.println("ADD USER DAO -------------->");
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public User select(String username) {
        User user = null;
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM user WHERE username=?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setType(rs.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	System.out.println("GET USER DAO -------------->");
        return user;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("SELECT * FROM user");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setType(rs.getString("type"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	System.out.println("GET_ALL USER DAO -------------->");
        return users;
    }

    @Override
    public int delete(String username) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("DELETE FROM user WHERE username=?");
            preparedStatement.setString(1, username);
        	System.out.println("DELETE USER DAO -------------->");
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(String[] values, String username) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("UPDATE user SET password=?, type=? WHERE username=?");
            preparedStatement.setString(1, values[0]); 
            preparedStatement.setString(2, values[1]); 
            preparedStatement.setString(3, username);
        	System.out.println("UPDATE USER DAO -------------->");
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}