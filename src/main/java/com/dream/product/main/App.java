package com.dream.product.main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.product.dao.User;
import com.dream.product.ui.SystemUi;

public class App {

	public static void main(String[] args) throws IOException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		SystemUi ui = (SystemUi) context.getBean("systemui");
		User user = null;
		while(user == null) {
			user = ui.getAuthenticationUi();
			if(user == null ) {
				System.out.println("[Info] User not available ");
			}
		}
		if(user != null) {
			if(user.getType().equals("admin")) {
				ui.getAdminUi();
			}
			else if(user.getType().equals("customer")) {
				ui.getCustomerUi();
			}
		}
	}
}
