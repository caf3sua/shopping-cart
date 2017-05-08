/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.webware.dao.CustomerDao;
import com.webware.persistence.Customer;
import com.webware.service.CustomerService;

/**
 * Customer service used to handle the Customer
 * 
 * It provides a layer of abstraction between the application and the data access layer
 * It provides a place to add additional real business logic or business rules
 * 
 */
@Service("customerService")
@Configurable
public class CustomerServiceImpl implements CustomerService {
	
	/** CustomerDao instance */
	@Autowired
	private CustomerDao customerDao;

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.CustomerService#findById(long)
	 */
	@Override
	public Customer findById(long id) {
		return customerDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.CustomerService#save(com.webware.persistence.Customer)
	 */
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.CustomerService#update(com.webware.persistence.Customer)
	 */
	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.CustomerService#delete(com.webware.persistence.Customer)
	 */
	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.CustomerService#shutdown()
	 */
	@Override
	public void shutdown() {
		customerDao.shutdown();
	}
}
