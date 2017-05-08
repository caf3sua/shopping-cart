/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.persistence;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity describing Category registered on the system.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com> 
 */
@Entity
@Table(name = "Category")
public class Category implements Serializable {
	
	/** Serialization id */
	private static final long serialVersionUID = 1L;

	/** The Category's id attribute */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	/** The Category categoryName attribute */
	@Column(name = "CategoryName")
	private String categoryName;
	
	/** The Category categoryCode attribute */
	@Column(name = "CategoryCode")
	private String categoryCode;
	
	/** The Category image attribute */
	@Column(name = "Image")
	private String image;
	
	/** The Category description attribute */
	@Column(name = "Description")
	private String description;
	
	/** The Category active attribute */
	@Column(name = "Active", nullable = false, columnDefinition = "TINYINT(1)")
	private boolean active;
	
	/** The Category listProducts attribute */
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER )
	private Set<Product> listProducts;
	
	/**
	 * Constructor method
	 */
	public Category() {		
	}
	
	/**
	 * Constructor method
	 * 
	 * @param categoryName
	 * @param categoryCode
	 * @param image
	 * @param description
	 * @param active
	 */
	public Category(String categoryName, String categoryCode, String image, String description, boolean active) {
		this.categoryName = categoryName;
		this.categoryCode = categoryCode;
		this.image = image;
		this.description = description;
		this.active = active;
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
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the categoryCode
	 */
	public String getCategoryCode() {
		return categoryCode;
	}

	/**
	 * @param categoryCode the categoryCode to set
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
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
	 * @return the listProducts
	 */
	public Set<Product> getListProducts() {
		return listProducts;
	}

	/**
	 * @param listProducts the listProducts to set
	 */
	public void setListProducts(Set<Product> listProducts) {
		this.listProducts = listProducts;
	}

}
