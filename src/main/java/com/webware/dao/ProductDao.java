/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.dao;

import java.util.List;

import com.webware.persistence.Product;

/**
 * Handles database interactions for ProductDao.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public interface ProductDao {
	
	/**
	 * Find a Product by ID
	 * 
	 * @param id The ID of the Product
	 * @return Product entity
	 */
	public Product findById(int id);

	/**
	 * Get all Product from database by category
	 * 
	 * @return list of Product entity
	 */
	public List<Product> findByCategory(int categoryId);

	/**
	 * Find all the Product
	 * 
	 * @param Product the Product entity
	 */
	public List<Product> findAll();

	/**
	 * Save the Product
	 * 
	 * @param Product the Product entity
	 */
	public void save(Product productModel);

	/**
	 * update the Product
	 * 
	 * @param Product the Product entity
	 */
	public void update(Product productModel);

	/**
	 * delete the Product
	 * 
	 * @param Product the Product entity
	 */
	public void delete(Product productModel);

	/**
	 * shutdown the current session 
	 */
	public void shutdown();

}
