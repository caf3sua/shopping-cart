/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Object view for ShoppingCart model information.
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public class ShoppingCartModel implements Serializable {

	/** generated serial version id */
	private static final long serialVersionUID = -3221821692871840247L;

	/** orders property */
	private List<OrderModel> orders;
	
	/** mapOrders property */
	private HashMap<Integer, OrderModel> mapOrders;
	
	/** totalAmount property */
	private double totalAmount = 0.0;
	
	/** numberProducts property */
	private int numberProducts;

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
	 * @param orders
	 *            the orders to set
	 */
	public void setOrders(List<OrderModel> orders) {
		this.orders = orders;
	}

	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		totalAmount = 0;

		for (OrderModel orderModel : getOrders()) {
			totalAmount = totalAmount + orderModel.getTotalAmount();
		}
		
		return totalAmount;
	}

	/**
	 * @param totalAmount
	 *            the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the numberProducts
	 */
	public int getNumberProducts() {
		numberProducts = getMapOrders().size();
		return numberProducts;
	}

	/**
	 * @param numberProducts
	 *            the numberProducts to set
	 */
	public void setNumberProducts(int numberProducts) {
		this.numberProducts = numberProducts;
	}

	/**
	 * @return the mapOrders
	 */
	public HashMap<Integer, OrderModel> getMapOrders() {
		if (null == mapOrders) {
			mapOrders = new HashMap<Integer, OrderModel>();
		}
		return mapOrders;
	}

	/**
	 * @param mapOrders
	 *            the mapOrders to set
	 */
	public void setMapOrders(HashMap<Integer, OrderModel> mapOrders) {
		this.mapOrders = mapOrders;
	}

	/**
	 * Intended only for debugging.
	 *
	 * <P>
	 * Here, the contents of every field are placed into the result, with one
	 * field per line.
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		result.append(this.getClass().getName() + " Object {" + NEW_LINE);
		result.append("    totalAmount: " + getTotalAmount() + NEW_LINE);
		result.append("    Number of Products: " + getNumberProducts() + NEW_LINE);
		result.append("    Map order: " + NEW_LINE);
		for (Map.Entry<Integer, OrderModel> entry : getMapOrders().entrySet()) {
			OrderModel obj = entry.getValue();
			result.append("       Order (ProductID:" + obj.getProductId() + ", Price: " + obj.getPrice()
					+ ", Total Amount: " + obj.getTotalAmount()
					+ ", Quantity: " + obj.getQuantity() + ")" + NEW_LINE);
		}
		result.append("}");
		result.append("    List order: " + NEW_LINE);
		for (OrderModel obj : orders) {
			result.append("       Order (ProductID:" + obj.getProductId() + ", Price: " + obj.getPrice()
			+ ", Total Amount: " + obj.getTotalAmount()
			+ ", Quantity: " + obj.getQuantity() + ")" + NEW_LINE);
		}
		result.append("}");
		
		return result.toString();
	}
}
