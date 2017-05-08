/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.model;

import java.io.Serializable;

import com.webware.persistence.Category;

/**
 * Object view for Product information.
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public class ProductModel implements Serializable {
    
	/** generated serial version id */
	private static final long serialVersionUID = -1471441297432363483L;
	
	/** id property */
	private int id;
	
	/** name property */
    private String name;
    
    /** description property */
    private String description;
    
    /** purchasePrice property */
    private double purchasePrice;
    
    /** salePrice property */
    private double salePrice;
    
    /** quantity property */
    private long quantity;
    
    /** category property */
    private Category category;
    
    /** image property */
    private String image;
    
    /** year property */
	private String year;
	
	/** code property */
	private String code;
	
	/** userQuantity property */
	private int userQuantity;
	
	/** message property */
	private String message;
	
	/** categoryId property */
	private int categoryId;
	
	/** disableUpdate property */
	private boolean disableUpdate = true;
    
	/**
	 * Constructor method
	 */
	public ProductModel() {
    }
	
	/**
	 * Constructor method 
	 * 
	 * @param id
	 * @param name
	 * @param description
	 * @param purchasePrice
	 * @param salePrice
	 * @param image
	 * @param category
	 * @param code
	 */
    public ProductModel(int id, String name, String description, double purchasePrice, double salePrice, String image, Category category, String code) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.setPurchasePrice(purchasePrice);
        this.setSalePrice(salePrice);
        this.image = image;
        this.category = category;
        this.code = code;
    }
    
    
	/**
	 * @return the disableUpdate
	 */
	public boolean isDisableUpdate() {
		return disableUpdate;
	}

	/**
	 * @param disableUpdate the disableUpdate to set
	 */
	public void setDisableUpdate(boolean disableUpdate) {
		this.disableUpdate = disableUpdate;
	}

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
	 * @return the purchasePrice
	 */
	public double getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * @param purchasePrice the purchasePrice to set
	 */
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	 * @return the salePrice
	 */
	public double getSalePrice() {
		return salePrice;
	}

	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * @return the quantity
	 */
	public long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
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
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
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
	 * @return the userQuantity
	 */
	public int getUserQuantity() {
		return userQuantity;
	}

	/**
	 * @param userQuantity the userQuantity to set
	 */
	public void setUserQuantity(int userQuantity) {
		this.userQuantity = userQuantity;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	
}
