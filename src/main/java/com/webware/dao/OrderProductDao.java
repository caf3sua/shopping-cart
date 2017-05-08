/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.dao;

import java.util.List;

import com.webware.persistence.OrderProductEntity;

/**
 * Handles database interactions for OrderProductEntity.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public interface OrderProductDao {
	
	/**
	 * Find a OrderProductEntity by ID
	 * 
	 * @param id The ID of the OrderProductEntity
	 * @return OrderProductEntity entity
	 */
	public OrderProductEntity findById(long id);

	/**
	 * Get all OrderProductEntity from database
	 * 
	 * @return list of OrderProductEntity entity
	 */
	public List<OrderProductEntity> findAll();

	/**
	 * Save the OrderProductEntity
	 * 
	 * @param OrderProductEntity the OrderProductEntity entity
	 */
	public void save(OrderProductEntity customer);

	/**
	 * update the OrderProductEntity
	 * 
	 * @param OrderProductEntity the OrderProductEntity entity
	 */
	public void update(OrderProductEntity customer);

	/**
	 * delete the OrderProductEntity
	 * 
	 * @param OrderProductEntity the OrderProductEntity entity
	 */
	public void delete(OrderProductEntity customer);

	/**
	 * shutdown the current session 
	 */
	public void shutdown();
}
