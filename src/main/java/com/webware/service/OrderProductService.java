/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.service;

import java.util.List;

import com.webware.persistence.OrderProductEntity;

/**
 * Service class used to interact with OrderProductEntity.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public interface OrderProductService {
	/**
	 * Find the OrderProductEntity by ID
	 * 
	 * @param id the ID of OrderProductEntity
	 * @return the OrderProductEntity object
	 */
	public OrderProductEntity findById(int id);

	public List<OrderProductEntity> findAll();

	/**
	 * save the OrderProductEntity to database
	 * 
	 * @param OrderProductEntity the OrderProductEntity object
	 */
	public void save(OrderProductEntity category);

	/**
	 * update the OrderProductEntity to database
	 * 
	 * @param OrderProductEntity the OrderProductEntity object
	 */
	public void update(OrderProductEntity category);

	/**
	 * delete the OrderProductEntity to database
	 * 
	 * @param OrderProductEntity the OrderProductEntity object
	 */
	public void delete(OrderProductEntity category);

	/**
	 * Shutdown the current session
	 */
	public void shutdown();
}
