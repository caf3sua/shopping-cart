/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webware.persistence.UserEntity;

/**
 * Implements the data access methods for UserDao persistence
 *
 */
@Repository("userDao")
@Transactional
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	/** SessionFactory instance */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * The init method
	 */
	@Autowired
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.UserDao#getUser(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public UserEntity getUser(String username) {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		Query query = sessionFactory.getCurrentSession().createQuery("from UserEntity u where u.userName = :userName");
		query.setParameter("userName", username);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.dao.UserDao#shutdown()
	 */
	@Override
	public void shutdown() {
		getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("SHUTDOWN").executeUpdate();
	}
}
