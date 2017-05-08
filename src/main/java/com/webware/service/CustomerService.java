/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.service;

import java.util.List;

import com.webware.persistence.Customer;

/**
 * Service class used to interact with Customer.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public interface CustomerService {
	
	/**
	 * Find the Customer by ID
	 * 
	 * @param id the ID of Customer
	 * @return the Customer object
	 */
	public Customer findById(long id);

	/**
	 * Find all Customer
	 * 
	 * @return list of Customer
	 */
	public List<Customer> findAll();

	/**
	 * save the Customer to database
	 * 
	 * @param Customer the Customer object
	 */
	public void save(Customer customer);

	/**
	 * update the Customer to database
	 * 
	 * @param Customer the Customer object
	 */
	public void update(Customer customer);

	/**
	 * delete the Customer to database
	 * 
	 * @param Customer the Customer object
	 */
	public void delete(Customer customer);

	/**
	 * Shutdown the current session
	 */
	public void shutdown();
}
