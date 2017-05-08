/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.dao;

import java.util.List;

import com.webware.persistence.Customer;

/**
 * Handles database interactions for Customer.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public interface CustomerDao {
	
	/**
	 * Find a Customer by ID
	 * 
	 * @param id The ID of the customer
	 * @return Customer enity
	 */
	public Customer findById(long id);

	/**
	 * Get all Customer from database
	 * 
	 * @return list of Customer entity
	 */
	public List<Customer> findAll();

	/**
	 * Save the Customer
	 * 
	 * @param customer the Customer entity
	 */
	public void save(Customer customer);

	/**
	 * update the Customer
	 * 
	 * @param customer the Customer entity
	 */
	public void update(Customer customer);

	/**
	 * delete the Customer
	 * 
	 * @param customer the Customer entity
	 */
	public void delete(Customer customer);

	/**
	 * shutdown the current session 
	 */
	public void shutdown();
}
