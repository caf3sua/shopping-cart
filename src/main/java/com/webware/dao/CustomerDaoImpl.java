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

import com.webware.dao.CustomerDao;
import com.webware.persistence.Customer;

/**
 * Implements the data access methods for Customer persistence
 *
 */
@Repository("customerDao")
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	
	/** SessionFactory instance */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.CustomerDao#findById(long)
	 */
	@Override
	public Customer findById(long id) {
		return (Customer) getHibernateTemplate().get(Customer.class, id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.CustomerDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll() {
		return sessionFactory.openSession().createQuery(" from Customer").list();
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.CustomerDao#save(com.webware.persistence.Customer)
	 */
	@Override
	public void save(Customer customer) {
		getHibernateTemplate().save(customer);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.CustomerDao#update(com.webware.persistence.Customer)
	 */
	@Override
	public void update(Customer customer) {
		getHibernateTemplate().update(customer);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.CustomerDao#delete(com.webware.persistence.Customer)
	 */
	@Override
	public void delete(Customer customer) {
		getHibernateTemplate().delete(customer);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.CustomerDao#shutdown()
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