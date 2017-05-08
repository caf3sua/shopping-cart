/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webware.persistence.OrderProductEntity;

/**
 * Implements the data access methods for OrderProduct persistence
 *
 */
@Repository("orderProductDao")
@Transactional
public class OrderProductDaoImpl extends HibernateDaoSupport implements OrderProductDao {
	
	/** SessionFactory instance */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.OrderProductDao#findById(long)
	 */
	@Override
	public OrderProductEntity findById(long id) {
		return (OrderProductEntity) sessionFactory.getCurrentSession().get(OrderProductEntity.class, id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.OrderProductDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderProductEntity> findAll() {
		return sessionFactory.getCurrentSession().createQuery(" from OrderProduct").list();
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.OrderProductDao#save(com.webware.persistence.OrderProductEntity)
	 */
	@Override
	public void save(OrderProductEntity customer) {
		sessionFactory.getCurrentSession().save(customer);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.OrderProductDao#update(com.webware.persistence.OrderProductEntity)
	 */
	@Override
	public void update(OrderProductEntity customer) {
		sessionFactory.getCurrentSession().update(customer);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.OrderProductDao#delete(com.webware.persistence.OrderProductEntity)
	 */
	@Override
	public void delete(OrderProductEntity customer) {
		sessionFactory.getCurrentSession().delete(customer);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.OrderProductDao#shutdown()
	 */
	@Override
	public void shutdown() {
		sessionFactory.getCurrentSession().getSessionFactory().openSession().createSQLQuery("SHUTDOWN").executeUpdate();
	}

	/*
	 * Init method
	 */
	@Autowired
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}