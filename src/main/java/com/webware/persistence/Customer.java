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
import javax.persistence.Table;

/**
 * Entity describing Customer registered on the system.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com> 
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

	/** Serialization id */
	private static final long serialVersionUID = 1L;

	/** The Customer's id attribute */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	/** The Customer firstName attribute */
	@Column(name = "FIRSTNAME")
	private String firstName;

	/** The Customer lastName attribute */
	@Column(name = "LASTNAME")
	private String lastName;

	/** The Customer email attribute */
	@Column(name = "EMAIL")
	private String email;

	/** The Customer password attribute */
	@Column(name = "PASSWORD")
	private String password;

	/**
	 * Constructor method
	 */
	public Customer() {
	}

	/**
	 * Constructor method
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 */
	public Customer(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
}