/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.webware.dao.CategoryDao;
import com.webware.persistence.Category;

/**
 * Category service used to handle the category
 * 
 * It provides a layer of abstraction between the application and the data access layer
 * It provides a place to add additional real business logic or business rules
 * 
 */
@Service("categoryService")
@Configurable
public class CategoryServiceImpl implements CategoryService{

	/** CategoryDao instance */
	@Autowired
	private CategoryDao categoryDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.webware.service.CategoryService#findById(int)
	 */
	@Override
	public Category findById(int id) {
		return categoryDao.findById(Integer.valueOf(id));
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.CategoryService#findAll()
	 */
	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.CategoryService#save(com.webware.persistence.Category)
	 */
	@Override
	public void save(Category category) {
		categoryDao.save(category);
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.CategoryService#update(com.webware.persistence.Category)
	 */
	@Override
	public void update(Category category) {
		categoryDao.update(category);
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.CategoryService#delete(com.webware.persistence.Category)
	 */
	@Override
	public void delete(Category category) {
		categoryDao.delete(category);
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.CategoryService#shutdown()
	 */
	@Override
	public void shutdown() {
		categoryDao.shutdown();		
	}

}
