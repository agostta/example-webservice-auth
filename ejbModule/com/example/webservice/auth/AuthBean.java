package com.example.webservice.auth;

import javax.ejb.Stateless;

@Stateless
public class AuthBean {

	private ThreadLocal<String> users = new ThreadLocal<>();
	
	/**
	 * Validate username and password
	 * @param username
	 * @param password
	 */
	public void validate(String username, String password){
		
		if( !"marcos".equals(username) || !"123".equals(password))
			throw new RuntimeException("Senha incorreta");
	}
	
	/**
	 * Return the user e-mail connected
	 * @return
	 */
	public String getUserConnected(){
		return users.get();
	}
	
}
