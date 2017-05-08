/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.webware.dao.ProductDao;
import com.webware.persistence.Product;

/**
 * Product service used to handle the Product
 * 
 * It provides a layer of abstraction between the application and the data access layer
 * It provides a place to add additional real business logic or business rules
 * 
 */
@Service("productService")
@Configurable
public class ProductServiceImpl implements ProductService {
	
	/** ProductDao isntance */
	@Autowired
	private ProductDao productDao;

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.ProductService#findById(int)
	 */
	@Override
	public Product findById(int id) {
		return productDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.ProductService#findByCategory(int)
	 */
	@Override
	public List<Product> findByCategory(int categoryId) {
		return productDao.findByCategory(categoryId);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.webware.service.ProductService#findAll()
	 */
	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.ProductService#save(com.webware.persistence.Product)
	 */
	@Override
	public void save(Product Product) {
		productDao.save(Product);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.ProductService#update(com.webware.persistence.Product)
	 */
	@Override
	public void update(Product Product) {
		productDao.update(Product);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.ProductService#delete(com.webware.persistence.Product)
	 */
	@Override
	public void delete(Product Product) {
		productDao.delete(Product);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.ProductService#shutdown()
	 */
	@Override
	public void shutdown() {
		productDao.shutdown();
	}

}
