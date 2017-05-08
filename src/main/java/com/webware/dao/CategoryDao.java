/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.dao;

import java.util.List;

import com.webware.persistence.Category;

/**
 * Handles database interactions for Category.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public interface CategoryDao {
	/**
	 * Find a Category by ID
	 * 
	 * @param id The ID of the Category
	 * @return Category entity
	 */
	public Category findById(Integer id);

	/**
	 * Get all category from database
	 * 
	 * @return list of category entity
	 */
	public List<Category> findAll();

	/**
	 * Save the category
	 * 
	 * @param category the category entity
	 */
	public void save(Category category);

	/**
	 * Save the category
	 * 
	 * @param category the category entity
	 */
	public void update(Category category);

	/**
	 * Save the Category
	 * 
	 * @param category the category entity
	 */
	public void delete(Category category);

	/**
	 * shutdown the current session 
	 */
	public void shutdown();
}
