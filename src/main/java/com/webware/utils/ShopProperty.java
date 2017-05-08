/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class utils used to read file shop configuration property
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
public class ShopProperty {
	
	/**
	 * Load value config by key (shop.property)
	 * 
	 * @param key
	 * @return value from key
	 */
	public static String loadPropertiesByKey(String key) {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = ShopProperty.class.getClassLoader().getResourceAsStream("/shop.properties");

			// load a properties file
			prop.load(input);
			
			return prop.getProperty(key);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return "";
	}
}
