/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Class validator for email field
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
@FacesValidator("EmailValidator")
public class EmailValidator implements Validator {

	/** email pattern */
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\."
			+ "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" + "(\\.[A-Za-z]{2,})$";

	/** pattern property */
	private Pattern pattern;
	
	/** pattern property */
	private Matcher matcher;

	/**
	 * Constructor method
	 */
	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	/*
	 * (non-Javadoc)
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		matcher = pattern.matcher(value.toString());
		if (!matcher.matches()) {

			FacesMessage msg = new FacesMessage("E-mail validation failed.", "Invalid E-mail format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

	}
}