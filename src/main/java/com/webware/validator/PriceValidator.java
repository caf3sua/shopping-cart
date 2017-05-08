/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Class validator for price field
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
@FacesValidator("PriceValidator")
public class PriceValidator implements Validator {

	/**
	 * Constructor method
	 */
	public PriceValidator() {
	}

	/*
	 * (non-Javadoc)
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		double price = (double) value;
		
		if (price < 1 || price > 10) {
			FacesMessage msg = new FacesMessage("Price validation failed.", "Invalid Price range (from 1.00 to 10.00)");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}
}