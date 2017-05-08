/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.dao;

import com.webware.persistence.UserEntity;

/**
 * Handles database interactions for UserDao.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public interface UserDao {
	/**
	 * Get User by username
	 * @param username the UserName of user
	 * @return the User object
	 */
	public UserEntity getUser(String username);

	/**
	 * shutdown the current session 
	 */
	public void shutdown();
}
