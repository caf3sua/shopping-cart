/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity describing user role registered on the system.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com> 
 */
@Entity
@Table(name = "UserRole",  uniqueConstraints = {
		@UniqueConstraint(columnNames = "UserId"),
		@UniqueConstraint(columnNames = "RoleId") })
public class UserRoleEntity implements Serializable {
	
	/** Serialization id */
	private static final long serialVersionUID = 1L;
	
	/** The UserRole id attribute */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	/** The UserRole userId attribute */
	@Column(name = "UserId")
	private Integer userId;
	
	/** The UserRole roleId attribute */
	@Column(name = "RoleId")
	private Integer roleId;
	
	/** The UserRole user attribute */
	@OneToOne(optional=false)
    @JoinColumn(name="UserId",referencedColumnName="UserId", insertable=false, updatable=false)
	private UserEntity user;
	
	/** The UserRole role attribute */
	@OneToOne(optional=false)
    @JoinColumn(name="RoleId",referencedColumnName="RoleId", insertable=false, updatable=false)
	private RoleEntity role;
	
	/**
	 * Constructor method
	 */
	public UserRoleEntity(){
		
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the user
	 */
	public UserEntity getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	public RoleEntity getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
	
}
