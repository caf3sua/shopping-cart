/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.model;

import java.io.Serializable;
import java.util.Date;

import com.webware.utils.ShopConstants;

/**
 * Object view for Oder information.
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public class OrderModel implements Serializable {

	/** generated serial version id */
	private static final long serialVersionUID = -3221821692871840247L;
	
	/** sessionId property */
	private String sessionId;
	
	/** lastUpdated property */
	private Date lastUpdated;
	
	/** productId property */
	private int productId;
	
	/** quantity property */
	private long quantity;
	
	/** price property */
	private double price;
	
	/** totalAmount property */
	private double totalAmount;
	
	/** image property */
	private String image;
	
	/** productName property */
	private String productName;
	
	/** productCode property */
	private String productCode;
	
	/** message property */
	private String message;
	
	/**
	 * Recalculate the total amount
	 * 
	 * @return true if recalculate success
	 */
	public boolean reCalculateTotalAmount() {
		int numPack = (int) quantity / ShopConstants.ONE_UNIT_PACK_QUANTITY;
		totalAmount =  numPack * price;
		return true;
	}
	
	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	/**
	 * @return the lastUpdated
	 */
	public Date getLastUpdated() {
		return lastUpdated;
	}
	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
