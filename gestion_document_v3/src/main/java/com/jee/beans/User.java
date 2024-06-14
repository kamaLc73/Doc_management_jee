package com.jee.beans;

public class User {
	
    private String username;
    private String password;
    private String type;

    public User() {
	}
    
    public User(String username, String password, String type) {
        this.username = username;
        this.password = password;
        setType(type);
    }
    
    public String getUsername() {
		return username;
	}

    public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
        if (type.equalsIgnoreCase("admin") || type.equalsIgnoreCase("user")) {
            this.type = type.toLowerCase();
        } else {
            throw new IllegalArgumentException("Le type d'utilisateur doit être 'admin' ou 'user'.");
        }
    }

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", type=" + type + "]";
	}
    
	
}