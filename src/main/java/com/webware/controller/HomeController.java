/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.controller;


import javax.faces.bean.ManagedBean;

/**
 * Home Controller class.
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
@ManagedBean(name = "home")
public class HomeController {

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
