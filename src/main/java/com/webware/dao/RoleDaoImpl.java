/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webware.persistence.RoleEntity;

/**
 * Implements the data access methods for RoleDao persistence
 *
 */
@Repository("roleDao")
@Transactional
public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

	/** The SessionFactory instance */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.RoleDao#getRole(int)
	 */
	public RoleEntity getRole(int id) {
		RoleEntity role = (RoleEntity) sessionFactory.getCurrentSession().load(RoleEntity.class, id);
		return role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.webware.dao.RoleDao#shutdown()
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
