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

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.webware.utils.ShopConstants;

/**
 * Class validator for quantity field
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
@Component
@Scope("request")
@FacesValidator("QuantityValidator")
public class QuantityValidator implements Validator {

	/**
	 * Constructor method
	 */
	public QuantityValidator() {
	}

	/*
	 * (non-Javadoc)
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		long quantity = (long) value;
		if (quantity <= 0 || quantity > ShopConstants.MAX_UNIT_QUANTITY) {
			FacesMessage msg = new FacesMessage("Quantity validation failed.", "Input quantity is invalid (range 250 - 10000)");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		
		int result = (int)quantity % ShopConstants.ONE_UNIT_PACK_QUANTITY;
		if (result != 0) {
			FacesMessage msg = new FacesMessage("Quantity validation failed.", "Please input multiples value of a unit (250g)");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}