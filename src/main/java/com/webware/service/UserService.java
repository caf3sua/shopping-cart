/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Service class used to interact with User.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public interface UserService {
	
	/**
	 * Load user by username
	 * 
	 * @param login the login name
	 * @return the UserDetails object
	 * @throws UsernameNotFoundException
	 */
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException;

	/**
	 * Get all authorities by RoleID
	 * 
	 * @param role the role ID
	 * @return the list of Authority
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role);

	/**
	 * Get list role name
	 * 
	 * @param role the role ID
	 * @return list role name
	 */
	public List<String> getRoles(Integer role);
}
