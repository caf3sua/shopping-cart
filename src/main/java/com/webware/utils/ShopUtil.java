/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.utils;

import com.webware.model.OrderModel;
import com.webware.model.ShoppingCartModel;

/**
 * Common utils class for shop
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public class ShopUtil {

	/**
	 * Push a product into shopping cart
	 * 
	 * @param cart ShoppingCartModel object view
	 * @param order OrderModel object view
	 * @return true if add success
	 */
	public static boolean pushUniqueProductIntoCart(ShoppingCartModel cart, OrderModel order) {
		OrderModel existOrder = cart.getMapOrders().get(order.getProductId());

		int numPack = (int) order.getQuantity() / ShopConstants.ONE_UNIT_PACK_QUANTITY;
		double totalAmount =  numPack * order.getPrice();

		if (existOrder == null) {
			order.setTotalAmount(totalAmount);
			cart.getMapOrders().put(order.getProductId(), order);
		} else {
			long newQuantity = existOrder.getQuantity() + order.getQuantity();
			double newTotalAmount = existOrder.getTotalAmount() + totalAmount;
			existOrder.setQuantity(newQuantity);
			existOrder.setTotalAmount(newTotalAmount);
		}
		
		return true;
	}
	
	/**
	 * Push a product into shopping cart
	 * 
	 * @param cart ShoppingCartModel object view
	 * @param order OrderModel object view
	 * @return true if add success
	 */
	public static boolean pushProductIntoCart(ShoppingCartModel cart, OrderModel order) {
		int numPack = (int) order.getQuantity() / ShopConstants.ONE_UNIT_PACK_QUANTITY;
		double totalAmount =  numPack * order.getPrice();

		order.setTotalAmount(totalAmount);
		cart.getMapOrders().put(order.getProductId(), order);
		cart.getOrders().add(order);
		
		return true;
	}
	
	/**
	 * Update a product into shopping cart
	 * 
	 * @param cart ShoppingCartModel object view
	 * @param order OrderModel object view
	 * @return true if add success
	 */
	public static boolean updateProductIntoCart(ShoppingCartModel cart, OrderModel order) {
		
		return true;
	}
}
