package com.medicapp.data.model;

public class LogInfo {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public LogInfo(String username, String token, int id, int accountType) {
		super();
		this.username = username;
		this.token = token;
		this.id = id;
		this.accountType = accountType;
	}

	private String username;

	private String token;

	private int id;

	private int accountType;

}
