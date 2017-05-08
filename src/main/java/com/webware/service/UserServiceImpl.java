/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webware.dao.UserDao;

/**
 * User service used to handle the User
 * 
 * It provides a layer of abstraction between the application and the data access layer
 * It provides a place to add additional real business logic or business rules
 */
@Service("userService")
@Configurable
public class UserServiceImpl implements UserService {

	/** ProductDao instance */
	@Autowired
	private UserDao userDAO;

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.UserService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.UserService#getAuthorities(java.lang.Integer)
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.webware.service.UserService#getRoles(java.lang.Integer)
	 */
	public List<String> getRoles(Integer role) {

		List<String> roles = new ArrayList<String>();

		if (role.intValue() == 1) {
			roles.add("ROLE_MODERATOR");
			roles.add("ROLE_ADMIN");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_MODERATOR");
		}
		return roles;
	}

	/*
	 * Grant authorities
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	/**
	 * @return the userDAO
	 */
	public UserDao getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDao userDAO) {
		this.userDAO = userDAO;
	}

}
