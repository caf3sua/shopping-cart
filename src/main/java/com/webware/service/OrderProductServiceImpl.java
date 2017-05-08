/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.webware.dao.OrderProductDao;
import com.webware.persistence.OrderProductEntity;

/**
 * OrderProduct service used to handle the OrderProduct
 * 
 * It provides a layer of abstraction between the application and the data access layer
 * It provides a place to add additional real business logic or business rules
 * 
 */
@Service("orderProductService")
@Configurable
public class OrderProductServiceImpl implements OrderProductService {

	/** OrderProductDao instance */
	@Autowired
	private OrderProductDao orderProductDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.webware.service.OrderProductService#findById(int)
	 */
	@Override
	public OrderProductEntity findById(int id) {
		return orderProductDao.findById(Integer.valueOf(id));
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.OrderProductService#findAll()
	 */
	@Override
	public List<OrderProductEntity> findAll() {
		return orderProductDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.OrderProductService#save(com.webware.persistence.OrderProductEntity)
	 */
	@Override
	public void save(OrderProductEntity orderProductEntity) {
		orderProductDao.save(orderProductEntity);
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.OrderProductService#update(com.webware.persistence.OrderProductEntity)
	 */
	@Override
	public void update(OrderProductEntity orderProductEntity) {
		orderProductDao.update(orderProductEntity);
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.OrderProductService#delete(com.webware.persistence.OrderProductEntity)
	 */
	@Override
	public void delete(OrderProductEntity orderProductEntity) {
		orderProductDao.delete(orderProductEntity);
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.OrderProductService#shutdown()
	 */
	@Override
	public void shutdown() {
		orderProductDao.shutdown();		
	}

}
