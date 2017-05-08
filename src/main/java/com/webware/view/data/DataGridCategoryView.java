/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.view.data;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.webware.controller.ShopController;
import com.webware.model.CategoryModel;


/**
 * ManagedBean is an main class responsible 
 * for actions related to view category
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
@ManagedBean
@ViewScoped
public class DataGridCategoryView implements Serializable {
	
	/** Default serial */
	private static final long serialVersionUID = 780644599674059195L;

	/** categories property */
	private List<CategoryModel> categories;
     
	/** selectedCatefory property */
    private CategoryModel selectedCatefory;
     
    /** shopController instance */
    @ManagedProperty("#{shop}")
    private ShopController shopController;
     
    /**
     * Init the ManagedBean
     */
    @PostConstruct
    public void init() {
    	setCategories(shopController.getAllCategories());
    }

	/**
	 * @return the categories
	 */
	public List<CategoryModel> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<CategoryModel> categories) {
		this.categories = categories;
	}

	/**
	 * @return the selectedCatefory
	 */
	public CategoryModel getSelectedCatefory() {
		return selectedCatefory;
	}

	/**
	 * @param selectedCatefory the selectedCatefory to set
	 */
	public void setSelectedCatefory(CategoryModel selectedCatefory) {
		this.selectedCatefory = selectedCatefory;
	}

	/**
	 * @return the shopController
	 */
	public ShopController getShopController() {
		return shopController;
	}

	/**
	 * @param shopController the shopController to set
	 */
	public void setShopController(ShopController shopController) {
		this.shopController = shopController;
	}

 
}