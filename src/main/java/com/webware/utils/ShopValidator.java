/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.utils;

/**
 * Common shop validator class
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public class ShopValidator {
	
	/**
	 * Validation quantity method 
	 * @param quantity input value
	 * @return message if validation has error
	 */
	public static String validateUserInputQuantity(int quantity) {
		if (quantity <= 0 || quantity > ShopConstants.MAX_UNIT_QUANTITY) {
			return "Input quantity is invalid (range 250 - 10000)";
		}
		
		int result = quantity % ShopConstants.ONE_UNIT_PACK_QUANTITY;
		if (result != 0) {
			return "Please input multiples value of a unit (250gms)";
		}
		
		return "";		
	}
}
