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
 * Entity describing users registered on the system.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com> 
 */
@Entity
@Table(name = "User")
public class UserEntity implements Serializable{

	/** Serialization id */
	private static final long serialVersionUID = 1L;
	
	/** The User id attribute */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UserId")
	private Integer userId;
	
	/** The User userName attribute */
	@Column(name = "UserName")
	private String userName;
	
	/** The User password attribute */
	@Column(name = "Password")
	private String password;
	
	/** The User firstName attribute */
	@Column(name = "FirstName")
	private String firstName;
	
	/** The User lastName attribute */
	@Column(name = "LastName")
	private String lastName;
	
	/** The User address attribute */
	@Column(name = "Address")
	private String address;
	
	/** The User email attribute */
	@Column(name = "Email")
	private String email;
	
	/** The User active attribute */
	@Column(name = "Active", nullable = false, columnDefinition = "TINYINT(1)")
	private boolean active;

	/** The User roles attribute */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="USERROLE",
        joinColumns = {@JoinColumn(name="UserId", referencedColumnName="UserId")},
        inverseJoinColumns = {@JoinColumn(name="RoleId", referencedColumnName="RoleId")}
    )
    private Set<RoleEntity> roles;
	
	/**
	 * Constructor method
	 */
	public UserEntity(){
	}
	
	/**
	 * @return the roles
	 */
	public Set<RoleEntity> getRoles() {
		return roles;
	}

	/**
	 * @param role the role to set
	 */
	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	
}
