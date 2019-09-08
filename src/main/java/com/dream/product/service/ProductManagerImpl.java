package com.dream.product.service;

import java.util.ArrayList;

import com.dream.product.dao.Product;

public class ProductManagerImpl implements ProductManager{
	private ArrayList<Product> productsList = new ArrayList<Product>();

	public void addProduct(Product product) {
		this.productsList.add(product);
	}

	public void deleteProduct(Product product) {
		this.productsList.remove(product);
		
	}

	public Product getProduct(String productName) {
		Product p=null;
		for(Product product : productsList  ) {
			if(product.getName().equals(productName)) {
				p=product;
			}
		}
		return p;
	}

	public boolean isProductAvailable(String productName) {
		boolean flag = false;
		for(Product product : productsList  ) {
			if(product.getName().equals(productName)) {
				flag = true;
			}
			else {
				flag = false;
			}
		}
		return flag;
	}

	public int getProductQuantity(Product product) {
		
		return product.getQuantity();
	}

	public void showProducts() {
		for(Product product: productsList) {
			System.out.println(product.toString());
		}
	}

	public void updateProduct(Product product) {
		
	}
	
	
}
