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

import com.webware.persistence.Category;

/**
 * Implements the data access methods for Category persistence
 *
 */
@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {
	/** SessionFactory instance */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.CategoryDao#findById(java.lang.Integer)
	 */
	@Override
	public Category findById(Integer id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.CategoryDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		return sessionFactory.getCurrentSession().createQuery(" from Category").list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.CategoryDao#save(com.webware.persistence.Category)
	 */
	@Override
	public void save(Category category) {
		getHibernateTemplate().save(category);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.CategoryDao#update(com.webware.persistence.Category)
	 */
	@Override
	public void update(Category category) {
		getHibernateTemplate().update(category);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.CategoryDao#delete(com.webware.persistence.Category)
	 */
	@Override
	public void delete(Category category) {
		getHibernateTemplate().delete(category);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.CategoryDao#shutdown()
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
