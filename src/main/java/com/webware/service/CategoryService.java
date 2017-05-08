/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.service;

import java.util.List;

import com.webware.persistence.Category;

/**
 * Service class used to interact with Category.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public interface CategoryService {
	
	/**
	 * Find the category by ID
	 * 
	 * @param id the ID of category
	 * @return the Category object
	 */
	public Category findById(int id);

	/**
	 * Find all category
	 * 
	 * @return list of category
	 */
	public List<Category> findAll();

	/**
	 * Save the category to database
	 * 
	 * @param category the Category object
	 */
	public void save(Category category);

	/**
	 * update the category to database
	 * 
	 * @param category the Category object
	 */
	public void update(Category category);

	/**
	 * delete the category to database
	 * 
	 * @param category the Category object
	 */
	public void delete(Category category);

	/**
	 * Shutdown the current session
	 */
	public void shutdown();
}
