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
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webware.dao.UserDao;
import com.webware.persistence.RoleEntity;

/**
 * UserDetails service used to handle the UserDetails
 * 
 * It provides a layer of abstraction between the application and the data access layer
 * It provides a place to add additional real business logic or business rules
 * 
 */
@Service("customUserDetailService")
@Configurable
public class CustomUserDetailServiceImpl implements UserDetailsService {

	/** UserDao instance */
	@Autowired
	private UserDao userDAO;

	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		com.webware.persistence.UserEntity userDB = userDAO.getUser(login);
		
		// Get List role
		List<String> roles = new ArrayList<String>();
		if (userDB.getRoles() != null && userDB.getRoles().size() != 0) {
			for (RoleEntity role : userDB.getRoles()) {
				roles.add(role.getRoleName());
			}
		}
		
		User domainUser = new User(userDB.getUserName(), userDB.getPassword(), getGrantedAuthorities(roles));
		
		// Set properties for UserLogin
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(domainUser.getUsername(), domainUser.getPassword(), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, domainUser.getAuthorities());
	}

	/*
	 * Get authorities by Role
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	/*
	 * Get roles by ID
	 */
	public List<String> getRoles(Integer role) {

		List<String> roles = new ArrayList<String>();
		
		if (role.intValue() == 0) {
			roles.add("ROLE_ADMIN");
		} else if (role.intValue() == 1) {
			roles.add("ROLE_STAFF");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_USER");
		} else if (role.intValue() == 3) {
			roles.add("ROLE_GUEST");
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

}
