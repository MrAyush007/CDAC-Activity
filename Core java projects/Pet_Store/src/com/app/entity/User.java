package com.app.entity;

public class User {
	private static int idGenerator;
	private int userId;
	private String email;
	private String pass;
	private Type type;
	private boolean admin;
	
	
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public static int getIdGenerator() {
		return idGenerator;
	}
	public static void setIdGenerator(int idGenerator) {
		User.idGenerator = idGenerator;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public User(String email, String pass, Type type) {
		super();
		this.userId=++idGenerator;
		this.email = email;
		this.pass = pass;
		this.type = type;
		this.admin=false;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", pass=" + pass
				+ "]";
	}
	
	
	
	
}
