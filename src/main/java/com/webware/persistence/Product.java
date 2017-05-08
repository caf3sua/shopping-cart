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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity describing Product registered on the system.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com> 
 */
@Entity
@Table(name = "Product",  uniqueConstraints = {
		@UniqueConstraint(columnNames = "CategoryId") })
public class Product implements Serializable{
	
	/** Serialization id */
	private static final long serialVersionUID = 1L;
	
	/** The Product id attribute */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	/** The Product name attribute */
	@Column(name = "Name")
	private String name;
	
	/** The Product description attribute */
	@Column(name = "Description")
	private String description;
	
	/** The Product purchasePrice attribute */
	@Column(name = "PurchasePrice", columnDefinition = "Decimal(10,2)")
	private double purchasePrice;
	
	/** The Product salePrice attribute */
	@Column(name = "SalePrice", columnDefinition = "Decimal(10,2)")
	private double salePrice;
	
	/** The Product quantity attribute */
	@Column(name = "Quantity")
	private long quantity;
	
	/** The Product categoryId attribute */
	@Column(name = "CategoryId", updatable=false, insertable=false)
	private Integer categoryId;
	
	/** The Product image attribute */
	@Column(name = "Image")
	private String image;
	
	/** The Product code attribute */
	@Column(name = "Code")
	private String code;
	
	/** The Product category attribute */
	@ManyToOne
    @JoinColumn(name="categoryId",referencedColumnName="ID")
	private Category category;

	/**
	 * Constructor method
	 */
	public Product(){
	}
	
	/**
	 * Constructor method
	 * 
	 * @param id
	 * @param name
	 * @param description
	 * @param purchasePrice
	 */
	public Product(Integer id, String name, String description, double purchasePrice) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.purchasePrice = purchasePrice;
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
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
	
}
