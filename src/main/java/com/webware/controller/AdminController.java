/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.controller;


import javax.faces.bean.ManagedBean;

/**
 * AdminController is an action controller responsible 
 * for administration as edit/update/add/manager products actions
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
@ManagedBean(name = "admin")
public class AdminController {
	
	/** Property */
	private String value = "Welcome page is provided by PrimeFaces - Copyrights by Webware";

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}


}
