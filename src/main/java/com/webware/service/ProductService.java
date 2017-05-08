/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.service;

import java.util.List;

import com.webware.persistence.Product;

/**
 * Service class used to interact with Product.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public interface ProductService {
	
	/**
	 * Find the Product by ID
	 * 
	 * @param id the ID of Product
	 * @return the Product object
	 */
	public Product findById(int id);

	/**
	 * Find all the products by category
	 * 
	 * @param categoryId
	 * @return the list of products
	 */
	public List<Product> findByCategory(int categoryId);

	/**
	 * Save the Product to database
	 * 
	 * @param Product the Product object
	 */
	public void save(Product Product);

	/**
	 * Save the Product to database
	 * 
	 * @param Product the Product object
	 */
	public void update(Product Product);

	/**
	 * Save the Product to database
	 * 
	 * @param Product the Product object
	 */
	public void delete(Product Product);

	/**
	 * Find all Product
	 * 
	 * @return list of Product
	 */
	public List<Product> findAll();

	/**
	 * Shutdown the current session
	 */
	public void shutdown();
}
