/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.persistence;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity describing Role registered on the system.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com> 
 */
@Entity
@Table(name = "Role")
public class RoleEntity implements Serializable{
  
	/** Serialization id */
	private static final long serialVersionUID = 1L;
	
	/** The Role id attribute */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RoleId")
	private Integer roleId;
	
	/** The Role roleName attribute */
	@Column(name = "RoleName")
	private String roleName;
	
	/** The Role description attribute */
	@Column(name = "Description")
	private String description;
	
	/** The Role active attribute */
	@Column(name = "Active", nullable = false, columnDefinition = "TINYINT(1)")
	private boolean active;
	
	/** The User users attribute */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="USERROLE",
        joinColumns = {@JoinColumn(name="RoleId", referencedColumnName="RoleId")},
        inverseJoinColumns = {@JoinColumn(name="UserId", referencedColumnName="UserId")}
    )
    private Set<UserEntity> users;
	
	/**
	 * Constructor method
	 */
	public RoleEntity(){
		
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the active
	 */
	public boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the users
	 */
	public Set<UserEntity> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}
	
}
