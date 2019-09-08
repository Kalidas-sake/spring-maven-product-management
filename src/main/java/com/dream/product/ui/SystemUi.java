package com.dream.product.ui;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.dream.product.dao.Product;
import com.dream.product.dao.User;
import com.dream.product.service.Authentication;
import com.dream.product.service.ProductManager;
import com.dream.product.service.ProductManagerImpl;

public class SystemUi {
	Scanner sc = new Scanner(System.in);
	Authentication auth;
	ProductManager productManager;

	public SystemUi(Authentication auth, ProductManagerImpl productManager) {
		this.auth = auth;
		this.productManager = productManager;
	}

	public void getAdminUi() {
		while (true) {
			System.out.println("1. Add Product \n2. show Product \n3. Exit \n");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("\nEnter product name: ");
				String name = sc.next();
				System.out.println("\nEnter quantity: ");
				int quantity = sc.nextInt();
				Product product = new Product(name, quantity);
				productManager.addProduct(product);
				System.out.println("[Info] New product added.");
				break;

			case 2:
				System.out.println("\n\n ####################################");
				productManager.showProducts();
				break;

			case 3:
				System.exit(0);
				break;

			default:
				System.out.println("Wrong input");
				break;
			}
		}
	}

	public void getCustomerUi() {
		System.out.println("hello customer");
		while (true) {

			System.out.println("1. Purchase Product \n2. View Products \n3. Exit \n");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Add choice");
				break;

			case 2:
				System.out.println("Delete choice");
				break;

			case 3:
				System.exit(0);
				break;

			default:
				System.out.println("Wrong input");
				break;
			}
		}

	}

	public User getAuthenticationUi() throws IOException {
		User user = null;
		System.out.println("Enter Username: ");
		String username = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();
		user = auth.authenticateUser(username, password);
		return user;
	}
}
