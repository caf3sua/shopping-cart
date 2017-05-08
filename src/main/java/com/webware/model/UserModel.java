/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.model;

import java.io.Serializable;

/**
 * Object view for User model information.
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public class UserModel implements Serializable {

	/** generated serial version id */
	private static final long serialVersionUID = -3221821692871840247L;
	
	/** login property */
	private String login;
	
	/** pwd property */
	private String pwd;
	
	/** pwdConfirm property */
	private String pwdConfirm;
	
	/** userName property */
	private String userName;
	
	/** password property */
	private String password;

	/**
	 * Reset method
	 */
	public void reset() {
		this.login = null;
		this.pwd = null;
		this.pwdConfirm = null;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the pwdConfirm
	 */
	public String getPwdConfirm() {
		return pwdConfirm;
	}

	/**
	 * @param pwdConfirm the pwdConfirm to set
	 */
	public void setPwdConfirm(String pwdConfirm) {
		this.pwdConfirm = pwdConfirm;
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

}
