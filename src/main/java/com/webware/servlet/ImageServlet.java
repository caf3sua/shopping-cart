/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.servlet;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webware.utils.ShopProperty;

/**
 * Image Servlet to stream the file to response.
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
@WebServlet(name = "ImageServlet", urlPatterns = { "/images/*" })
public class ImageServlet extends HttpServlet implements Serializable {

	/** Default serial */
	private static final long serialVersionUID = 1L;

	/** imagePath property */
	private String imagePath;

	/** imagePath property */
	private boolean isUseRelativePath;
	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		isUseRelativePath = Boolean.parseBoolean(ShopProperty.loadPropertiesByKey("use.default.upload.dir.path"));
		// Init image path
		imagePath = ShopProperty.loadPropertiesByKey("images.upload.dir");
	}

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramType = request.getParameter("type");
		String subFolder = "product/";
		if (paramType != null && paramType.equals("category")) {
			subFolder = "category/";
		}

		String filename = request.getPathInfo().substring(1);
		String imageFullPath = "";
		if (isUseRelativePath) {
			imageFullPath = request.getServletContext().getRealPath("/") + "../uploads/" + subFolder + filename;
		} else {
			imageFullPath = imagePath + subFolder + filename;
		}

		File file = new File(imageFullPath);
		// Check file is exist
		if (!file.isFile() || !file.exists()) {
			file = new File(imagePath + "no-images.jpg");
		}
		
		response.setHeader("Content-Type", getServletContext().getMimeType(filename));
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");
		Files.copy(file.toPath(), response.getOutputStream());
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath
	 *            the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the isUseRelativePath
	 */
	public boolean isUseRelativePath() {
		return isUseRelativePath;
	}

	/**
	 * @param isUseRelativePath the isUseRelativePath to set
	 */
	public void setUseRelativePath(boolean isUseRelativePath) {
		this.isUseRelativePath = isUseRelativePath;
	}

}