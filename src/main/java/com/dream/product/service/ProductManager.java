package com.dream.product.service;

import java.util.ArrayList;

import com.dream.product.dao.Product;

public interface ProductManager {

	void addProduct(Product product);
	void deleteProduct(Product product);
	Product getProduct(String productName);
	boolean isProductAvailable(String productName);
	int getProductQuantity(Product product);
	void showProducts();
	void updateProduct(Product product);
}
