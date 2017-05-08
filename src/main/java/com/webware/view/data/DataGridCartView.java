/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.view.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.context.RequestContext;

import com.webware.controller.ShopController;
import com.webware.model.OrderModel;
import com.webware.model.ShoppingCartModel;
import com.webware.utils.ShopConstants;
import com.webware.utils.ShopValidator;

/**
 * ManagedBean is an main class responsible 
 * for actions related to view shopping cart
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
@ManagedBean(name = "cartView")
@ViewScoped
public class DataGridCartView implements Serializable {
	/** Log instance */
	private static final Log LOG = LogFactory.getLog(DataGridCartView.class);
	
	/** Default serial */
	private static final long serialVersionUID = 880644599674059195L;

	/** orders property */
	private List<OrderModel> orders;
     
	/** selectedOrder property */
    private OrderModel selectedOrder;
    
    /** totalAmount property */
    private double totalAmount;
    
    /** shopController instance */
    @ManagedProperty("#{shop}")
    private ShopController shopController;
    
    /**
     * Init the ManagedBean
     */
    @PostConstruct
    public void init() {
    	getAllCartOrder();
    }

    /**
     * Get all shopping cart order and calulate the total amount
     */
    public void getAllCartOrder() {
    	LOG.debug("getAllCartOrder Start");
    	
    	// Get Order from session
    	FacesContext context = FacesContext.getCurrentInstance();
		ShoppingCartModel cart = (ShoppingCartModel) context.getExternalContext().getSessionMap().get(ShopConstants.SESSION_KEY_CART);
		if (null != cart && cart.getOrders().size() != 0) {
			// clear old data
			getOrders().clear();
			List<OrderModel> listOrders = new ArrayList<OrderModel>(cart.getOrders());
			getOrders().addAll(listOrders);
			
			// Get total amount
			totalAmount = cart.getTotalAmount();
		}
		
    }
    
    /**
     * Method used to update order of shopping cart, then update total amount and notify
     * 
     * @param order OrderModel view object
     * @return FacesContext navigator
     */
    public String updateProductToCart(OrderModel order) {
    	LOG.debug("updateProductToCart Start, order" + order);
    	
    	// Validation
    	String result = ShopValidator.validateUserInputQuantity((int)order.getQuantity());
    	order.setMessage(result);
    	if (result == "" || result == null) {
        	// re-calculate total amount
        	order.reCalculateTotalAmount();
    	}
    	
    	// Remove on session
    	FacesContext context = FacesContext.getCurrentInstance();
		ShoppingCartModel cart = (ShoppingCartModel) context.getExternalContext().getSessionMap().get(ShopConstants.SESSION_KEY_CART);
		LOG.debug("Cart after update, cart:" + cart);

		totalAmount = cart.getTotalAmount();
    	
    	RequestContext requestContext = RequestContext.getCurrentInstance();
    	requestContext.update("cart-amount-total");
    	requestContext.update("form-cart-page:header-cart-total-amount");
    	
		return null;
    }
    
    /**
     * Method used to remove order of shopping cart, then update total amount and notify
     * 
     * @param order OrderModel view object
     * @return FacesContext navigator
     */
    public String removeCartOrder(OrderModel order) {
    	LOG.debug("removeCartOrder Start");
    	
    	// Remove on session
    	FacesContext context = FacesContext.getCurrentInstance();
		ShoppingCartModel cart = (ShoppingCartModel) context.getExternalContext().getSessionMap().get(ShopConstants.SESSION_KEY_CART);
		cart.getMapOrders().remove(order.getProductId());
		
		// Remove table
    	getOrders().remove(order);
    	
    	if (getOrders().isEmpty()) {
    		return "no-cart";
    	}
		
		return null;
    }
    
    /**
     * Method used to update order of shopping cart, then update total amount and notify
     * 
     * @return FacesContext navigator
     */
    public String removeCartOrder() {
    	LOG.debug("removeCartOrder Start");
    	
    	// Remove on session
    	FacesContext context = FacesContext.getCurrentInstance();
		ShoppingCartModel cart = (ShoppingCartModel) context.getExternalContext().getSessionMap().get(ShopConstants.SESSION_KEY_CART);
		cart.getMapOrders().remove(selectedOrder.getProductId());
		
		// Remove table
    	getOrders().remove(selectedOrder);
    	
    	if (getOrders().isEmpty()) {
    		return "no-cart";
    	}
		
		return null;
    }
    
	/**
	 * @return the orders
	 */
	public List<OrderModel> getOrders() {
		if (orders == null) {
			orders = new ArrayList<OrderModel>();
		}
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<OrderModel> orders) {
		this.orders = orders;
	}

	/**
	 * @return the selectedOrder
	 */
	public OrderModel getSelectedOrder() {
		return selectedOrder;
	}

	/**
	 * @param selectedOrder the selectedOrder to set
	 */
	public void setSelectedOrder(OrderModel selectedOrder) {
		this.selectedOrder = selectedOrder;
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
}