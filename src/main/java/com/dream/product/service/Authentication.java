package com.dream.product.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.dream.product.dao.User;

public class Authentication {

	public User authenticateUser(String username, String password) throws IOException {
		User user = null;
		Properties p = new Properties();
		InputStream in = new FileInputStream("src/main/resources/users.properties");
		p.load(in);
		
		if(p.containsKey(username)) {
			
			String passString[] = p.getProperty(username).split("/");
			String type = passString[0];
			String pass = passString[1];
			if(pass.equals(password)) {
				user = new User(username, pass, type);
			}
			return user;
		}
		else {
			return user;
		}
	}
}
