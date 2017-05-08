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

import com.webware.persistence.Product;

/**
 * Implements the data access methods for Product persistence
 *
 */
@Repository("productDao")
@Transactional
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	/** SessionFactory instance */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.ProductDao#findByCategory(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByCategory(int categoryId) {
		return sessionFactory.getCurrentSession().createQuery(" from Product where CategoryId = " + categoryId).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.ProductDao#findById(int)
	 */
	@Override
	public Product findById(int id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.ProductDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		return sessionFactory.getCurrentSession().createQuery(" from Product").list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.ProductDao#save(com.webware.persistence.Product)
	 */
	@Override
	public void save(Product Product) {
		sessionFactory.getCurrentSession().save(Product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.ProductDao#update(com.webware.persistence.Product)
	 */
	@Override
	public void update(Product Product) {
		sessionFactory.getCurrentSession().update(Product);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.ProductDao#delete(com.webware.persistence.Product)
	 */
	@Override
	public void delete(Product Product) {
		sessionFactory.getCurrentSession().delete(Product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.ProductDao#shutdown()
	 */
	@Override
	public void shutdown() {
		getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("SHUTDOWN").executeUpdate();

	}

	/*
	 * Init method
	 */
	@Autowired
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

}
