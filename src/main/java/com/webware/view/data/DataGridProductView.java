/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.view.data;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.context.RequestContext;

import com.webware.controller.ShopController;
import com.webware.model.CategoryModel;
import com.webware.model.ProductModel;

/**
 * ManagedBean is an main class responsible 
 * for actions related to view product
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
@ManagedBean
@ViewScoped
public class DataGridProductView implements Serializable {
	
    /** Default serial */
	private static final long serialVersionUID = 880644599674059195L;

	/** products property */
	private List<ProductModel> products;
     
	/** selectedProduct property */
    private ProductModel selectedProduct;
    
    /** selectedCategory property */
    private CategoryModel selectedCategory;

    /** selectedCategoryId property */
    @ManagedProperty("#{param.selectedCategoryId}")
    private int selectedCategoryId;
    
    /** ShopController instance */
    @ManagedProperty("#{shop}")
    private ShopController shopController;
    
    /**
     * Method init for view bean
     */
    @PostConstruct
    public void init() {
    	getProductByCategoryId();
    }

    /**
     * Method get all products by Category then update message information
     * 
     */
    public void getProductByCategoryId() {
    	System.out.println("selectedCategory: " + selectedCategory);
    	setProducts(shopController.getProductByCategoryId(selectedCategoryId));
    	
    	// Call shop controller
    	setSelectedCategory(shopController.getCategoryById(selectedCategoryId));
    	
    	RequestContext requestContext = RequestContext.getCurrentInstance();
    	requestContext.update("display-selected-category-name");
    	requestContext.update("display-selected-category-description");
    	requestContext.update("form-cart-page:header-cart-total-amount");
    }
    
    /**
	 * Show message on view
	 * 
	 * @param summary message
	 */
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	/**
	 * @return the products
	 */
	public List<ProductModel> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	/**
	 * @return the selectedProduct
	 */
	public ProductModel getSelectedProduct() {
		return selectedProduct;
	}

	/**
	 * @param selectedProduct the selectedProduct to set
	 */
	public void setSelectedProduct(ProductModel selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	/**
	 * @return the selectedCategory
	 */
	public CategoryModel getSelectedCategory() {
		return selectedCategory;
	}

	/**
	 * @param selectedCategory the selectedCategory to set
	 */
	public void setSelectedCategory(CategoryModel selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	/**
	 * @return the selectedCategoryId
	 */
	public int getSelectedCategoryId() {
		return selectedCategoryId;
	}

	/**
	 * @param selectedCategoryId the selectedCategoryId to set
	 */
	public void setSelectedCategoryId(int selectedCategoryId) {
		this.selectedCategoryId = selectedCategoryId;
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