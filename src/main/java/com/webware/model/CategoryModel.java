/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.model;

import java.io.Serializable;
import java.util.Set;

/**
 * Object view for category.
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public class CategoryModel implements Serializable {
	
	/** generated serial version id */
	private static final long serialVersionUID = -4022884953966271672L;
	
	/** id property */
	private int id;
	
	/** name property */
	private String name;
	
	/** code property */
	private String code;
	
	/** image property */
	private String  image;
	
	/** active property */
	private boolean active;
	
	/** description property */
	private String description;
	
	/** lstProductModels property */
	private Set<ProductModel> lstProductModels;
	
	/**
	 * Constructor method
	 * 
	 * @param id
	 * @param name
	 * @param code
	 * @param image
	 * @param description
	 * @param active
	 */
	public CategoryModel(int id, String name, String code, String  image, String description, boolean active) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.image = image;
		this.active = active;
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
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
	 * @return the lstProductModels
	 */
	public Set<ProductModel> getLstProductModels() {
		return lstProductModels;
	}

	/**
	 * @param lstProductModels the lstProductModels to set
	 */
	public void setLstProductModels(Set<ProductModel> lstProductModels) {
		this.lstProductModels = lstProductModels;
	}

}
