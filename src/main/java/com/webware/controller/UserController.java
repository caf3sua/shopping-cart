/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.webware.model.UserModel;

/**
 * UserController is an authorization controller responsible 
 * for user login/logout/register actions
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
@ManagedBean(name = "user")
@ApplicationScoped
public class UserController {

	/** Log instance */
	private static final Log LOG = LogFactory.getLog(UserController.class);

	/** UserModel property using for view */
	private UserModel model = new UserModel();

	/** UserModel property contain login information */
	private UserModel loginBean = new UserModel();

	/** AuthenticationManager property */
	@ManagedProperty(value="#{authenticationManager}")
	private AuthenticationManager authenticationManager;

	/**
	 * Login method based on <code>HttpServletRequest</code> and security realm
	 * 
	 * @return FacesContext navigator
	 */
	public String login() {
		try {
			LOG.info("Login started for User with Name: " + getLoginBean().getUserName());

			// Validation
			if (getLoginBean().getUserName() == null || getLoginBean().getPassword() == null 
					|| getLoginBean().getUserName() == "" || getLoginBean().getPassword() == "") {
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Please input valid username and password.");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				LOG.info("Login not started because userName or Password is empty: " + getLoginBean().getUserName());
				return null;
			}

			// authenticate afainst spring security
			Authentication authenticationRequest = new UsernamePasswordAuthenticationToken(getLoginBean().getUserName(),
					getLoginBean().getPassword());

			Authentication result = authenticationManager.authenticate(authenticationRequest);
			SecurityContextHolder.getContext().setAuthentication(result);
			
			if (result.isAuthenticated()) {
	            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	            RequestCache requestCache = new HttpSessionRequestCache();
	            SavedRequest savedRequest = requestCache.getRequest(request, response);

	            if (null != savedRequest) {
		            String redirectUrl = savedRequest.getRedirectUrl();
		            response.sendRedirect(redirectUrl);
		            return null;
	            }
	        }
		} catch (Exception e) {
			LOG.info("Login failed: " + e.getMessage());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Login failed. Please try again later.");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);

			return null;
		}
		
		return "success";
	}
	
	/**
	 * Register method based on <code>HttpServletRequest</code> and security realm
	 * 
	 * @return FacesContext navigator
	 */
	public String register() {
		try {
			if (!model.getPwd().equals(model.getPwdConfirm())) {
				throw new Exception("Passwords do not match!!");
			}
			// userService.addUser(model);
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration Failure, " + e.getMessage(), ""));
			return null;
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration Success!", ""));
		model.reset();
		return "login";
	}

	/**
	 * Method check authentication of the user based on <code>HttpServletRequest</code> and security realm
	 * 
	 * @return boolean true if user is authenticated
	 */
	public boolean isAuthentication() {
        Authentication autenticacion = SecurityContextHolder.getContext().getAuthentication();
        boolean result = (autenticacion != null) &&
                            !(autenticacion instanceof AnonymousAuthenticationToken) &&
                            autenticacion.isAuthenticated();
        LOG.debug("isAuthentication: " + result);
        return result;
    }
	
	/**
	 * Method used to get logged user name based on <code>HttpServletRequest</code> and security realm
	 * 
	 * @return String name of user
	 */
	public String getLoggedUsername() {
        Authentication autenticacion = SecurityContextHolder.getContext().getAuthentication();
        boolean result = (autenticacion != null) &&
                            !(autenticacion instanceof AnonymousAuthenticationToken) &&
                            autenticacion.isAuthenticated();
        if (result) {
        	return autenticacion.getName();
        }
        return "";
    }
	
	public void afterPhase(PhaseEvent event) {
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
	 * 
	 * Do something before rendering phase.
	 */
	public void beforePhase(PhaseEvent event) {
		Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get(WebAttributes.AUTHENTICATION_EXCEPTION);

		if (e instanceof BadCredentialsException) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Username or password not valid.", "Username or password not valid"));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.event.PhaseListener#getPhaseId()
	 * 
	 * In which phase you want to interfere?
	 */
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	/**
	 * @return the loginBean
	 */
	public UserModel getLoginBean() {
		return loginBean;
	}

	/**
	 * @param loginBean the loginBean to set
	 */
	public void setLoginBean(UserModel loginBean) {
		this.loginBean = loginBean;
	}

	/**
	 * @return the model
	 */
	public UserModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(UserModel model) {
		this.model = model;
	}

	/**
	 * @return the authenticationManager
	 */
	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	/**
	 * @param authenticationManager the authenticationManager to set
	 */
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

}
