/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.dao;

import com.webware.persistence.RoleEntity;

/**
 * Handles database interactions for RoleDao.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public interface RoleDao {
	
	/**
	 * Get Role by ID
	 * 
	 * @param id the ID of Role
	 * @return The RoleEntity object
	 */
	public RoleEntity getRole(int id);
	
	/**
	 * shutdown the current session 
	 */
	public void shutdown();
}
