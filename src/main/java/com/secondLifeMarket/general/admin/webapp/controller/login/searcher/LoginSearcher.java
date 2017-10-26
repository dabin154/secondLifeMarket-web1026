package com.secondLifeMarket.general.admin.webapp.controller.login.searcher;

import java.io.Serializable;

public class LoginSearcher implements Serializable{
	
	private static final long serialVersionUID = -8460335665415322192L;
	
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
