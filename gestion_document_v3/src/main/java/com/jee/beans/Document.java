package com.jee.beans;

public class Document {
	private int id;
	private String title;
	private String type;
	private String path;
	private String author;
	private User user;
	
	public Document() {
	}

	public Document(int id, String title, String type, String path, String author, User user) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.path = path;
		this.author = author;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", type=" + type + ", path=" + path + ", author=" + author
				+ ", user=" + user + "]";
	}
}


