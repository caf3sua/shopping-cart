/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.controller;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.context.RequestContext;
import org.springframework.security.core.AuthenticationException;

import com.webware.model.CategoryModel;
import com.webware.model.OrderModel;
import com.webware.model.ProductModel;
import com.webware.model.ShoppingCartModel;
import com.webware.persistence.Category;
import com.webware.persistence.OrderDetailEntity;
import com.webware.persistence.OrderProductEntity;
import com.webware.persistence.Product;
import com.webware.service.CategoryService;
import com.webware.service.CustomerService;
import com.webware.service.OrderProductService;
import com.webware.service.ProductService;
import com.webware.utils.ShopConstants;
import com.webware.utils.ShopUtil;
import com.webware.utils.ShopValidator;

/**
 * ShopController is an main controller responsible 
 * for actions related to shop
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
@ManagedBean(name = "shop")
@ApplicationScoped
public class ShopController {
	
	/** Log instance */
	private static final Log LOG = LogFactory.getLog(ShopController.class);
	
	/** CustomerService instance */
	@ManagedProperty("#{customerService}")
	private CustomerService customerService;
	
	/** CategoryService instance */
	@ManagedProperty("#{categoryService}")
	private CategoryService categoryService;
	
	/** ProductService instance */
	@ManagedProperty("#{productService}")
	private ProductService productService;
	
	/** OrderProductService instance */
	@ManagedProperty("#{orderProductService}")
	private OrderProductService orderProductService;
	
	/** Shopping cart amount property */
	private double cartAmount = 0;
	
	/**
	 * Method add message when click button
	 * 
	 * @param actionEvent An ActionEvent represents the activation of a user interface component 
	 */
	public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Webware!!");
    }
	
	/**
	 * Show message on view
	 * 
	 * @param summary message
	 */
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	/**
	 * Show message info on view
	 * 
	 * @param summary message
	 */
	public void addMessageInfo(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	/**
	 * Go to cart page to user can show/remove/update the shopping cart
	 * 
	 * @return FacesContext navigator
	 */
	public String gotoCartPage() {
		try {
			LOG.info("gotoCartPage start");

			FacesContext context = FacesContext.getCurrentInstance();
			ShoppingCartModel cart = (ShoppingCartModel) context.getExternalContext().getSessionMap().get(ShopConstants.SESSION_KEY_CART);
			if (null == cart || cart.getMapOrders().size() == 0) {
				LOG.debug("ShoppingCart is empty, go to no-cart page");
				return "no-cart";
			}
			
		} catch (Exception e) {
			LOG.info("gotoCartPage failed: " + e.getMessage());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "gotoCartPage failed. Please try again later.");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);

			return null;
		}
		
		return "cart";
	}
	
	/**
	 * Checkout method based on <code>HttpServletRequest</code>
	 * 
	 * @return FacesContext navigator
	 */
	public String checkout() {
		try {
			LOG.info("Checkout your cart");

			FacesContext context = FacesContext.getCurrentInstance();
			ShoppingCartModel cart = (ShoppingCartModel) context.getExternalContext().getSessionMap().get(ShopConstants.SESSION_KEY_CART);
			
			if (cart == null || cart.getMapOrders().size() == 0) {
				LOG.debug("No product to save to DB");
				return "success";
			}
			
			// Process checkout
			OrderProductEntity orderProductEntity = convertShoppingCartToOrderEntity(cart);
			orderProductService.save(orderProductEntity);
			
			// Clean session
			context.getExternalContext().getSessionMap().put(ShopConstants.SESSION_KEY_CART, null);
		} catch (AuthenticationException e) {
			LOG.info("Checkout failed: " + e.getMessage());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Checkout failed. Please try again later.");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);

			return null;
		}
		
		return "success";
	}
	
	/**
	 * Convert ShoppingCart model view to OrderProduct entity object
	 * 
	 * @param cart object view
	 * @return OrderProduct entity
	 */
	private OrderProductEntity convertShoppingCartToOrderEntity(ShoppingCartModel cart) {
		OrderProductEntity order = new OrderProductEntity();
		// Order main
		order.setOrderDate(new Timestamp(System.currentTimeMillis()));
		order.setOrderAmount(cart.getTotalAmount());
		order.setStatusId(0); // WAITING
		// List order detail
		Set<OrderDetailEntity> setOrderDetail = new HashSet<OrderDetailEntity>();
		for (Map.Entry<Integer, OrderModel> entry : cart.getMapOrders().entrySet()) {
			OrderModel obj = entry.getValue();
			OrderDetailEntity orderDetail = new OrderDetailEntity();
			orderDetail.setProductId(obj.getProductId());
			orderDetail.setProductPrice(obj.getTotalAmount());
			orderDetail.setQuantity(obj.getQuantity());
			setOrderDetail.add(orderDetail);
		}
		
		order.setListOrderDetail(setOrderDetail);
		
		return order;
	}
	
	/**
	 * Add product into Shopping cart
	 * 
	 * @param product ProductModel view object
	 */
	public void addToCart(ProductModel product) {
		System.out.println("Add to cart:" + product);
		String result = ShopValidator.validateUserInputQuantity(product.getUserQuantity());
		
		RequestContext requestContext = RequestContext.getCurrentInstance();
		
		if (result == "") {
			// Add product into Shopping Cart object on session
			pushIntoShoppingCart(product);
			
			addMessageInfo("Added the Product into Cart!");
			requestContext.update("growl");
		} else {
			product.setMessage(result);
	    	requestContext.update("product-message");
		}
    }
	
	/**
	 * Push/Add product into shopping cart, then archive them on session
	 * 
	 * @param product ProductModel view object
	 * @return true if add success
	 */
	private boolean pushIntoShoppingCart(ProductModel product) {
		FacesContext context = FacesContext.getCurrentInstance();
		ShoppingCartModel cart = (ShoppingCartModel) context.getExternalContext().getSessionMap().get(ShopConstants.SESSION_KEY_CART);
		if (null == cart) {
			LOG.debug("ShoppingCart object is NULL, create new one");
			cart = new ShoppingCartModel();
		}
		
		OrderModel order = new OrderModel();
		order.setLastUpdated(new Date());
		order.setPrice(product.getSalePrice());
		order.setProductId(product.getId());
		order.setQuantity(product.getUserQuantity());
		order.setImage(product.getImage());
		order.setProductName(product.getName());
		order.setProductCode(product.getCode());
		order.setSessionId(context.getExternalContext().getSessionId(false));
		
		ShopUtil.pushProductIntoCart(cart, order);
		
		LOG.debug("ShoppingCart object :" + cart);
		
		// Push on session
		context.getExternalContext().getSessionMap().put(ShopConstants.SESSION_KEY_CART, cart);
		
		return true;
	}
	
	/**
	 * Retrieve/Get all product depend on the category default
	 * 
	 * @return list ProductModel view object
	 */
	public List<ProductModel> getProductByCategoryId(){
		List<ProductModel> listModels = new ArrayList<ProductModel>();
		List<Product> listProducts = productService.findByCategory(0);
		
		ProductModel model;
		for(Product product : listProducts){
			model = convertEntityToModel(product);
			listModels.add(model);
		}
		
		return listModels;
	}
	
	/**
	 * Retrieve/Get all product depend on the category Id
	 * 
	 * @return list ProductModel view object
	 */
	public List<ProductModel> getProductByCategoryId(int i){
		List<ProductModel> listModels = new ArrayList<ProductModel>();
		List<Product> listProducts = productService.findByCategory(i);
		
		ProductModel model;
		for(Product product : listProducts){
			model = convertEntityToModel(product);
			listModels.add(model);
		}
		
		return listModels;
	}
	
	/**
	 * Retrieve/Get all product of shop
	 * 
	 * @return list ProductModel view object
	 */
	public List<ProductModel> getAllProduct(){
		List<ProductModel> listModels = new ArrayList<ProductModel>();
		List<Product> listProducts = productService.findAll();
		
		ProductModel model;
		for(Product product : listProducts){
			model = convertEntityToModel(product);
			listModels.add(model);
		}
		
		return listModels;
	}
	
	/**
	 * Delete a product from shop (using by admin backend)
	 * 
	 * @return true if delete success
	 */
	public boolean deleteProduct(int productId){
		Product product = productService.findById(productId);
		
		if (product != null) {
			productService.delete(product);
		}
		
		return true;
	}
	
	/**
	 * Update a product using by admin backend
	 * 
	 * @param ProductModel objet view
	 * @return true if update success
	 */
	public boolean updateProduct(ProductModel product){
		Product productEntity = productService.findById(product.getId());
		
		if (productEntity != null) {
			// Set updated field
			productEntity.setDescription(product.getDescription());
			productEntity.setName(product.getName());
			productEntity.setQuantity(product.getQuantity());
			productEntity.setSalePrice(product.getSalePrice());
			productService.update(productEntity);
		}
		
		return true;
	}
	
	/**
	 * Update a product image using by admin backend
	 * 
	 * @param productID the ID of product objet view
	 * @return true if update success
	 */
	public boolean updateProductImage(int productID, String newImage){
		Product productEntity = productService.findById(productID);
		
		if (productEntity != null) {
			// Set updated field
			productEntity.setImage(newImage);
			productService.update(productEntity);
		}
		
		return true;
	}
	
	/**
	 * Add a product to shop (using by admin backend)
	 * 
	 * @param product ProductModel object view bean
	 * @return
	 */
	public boolean addProduct(ProductModel product){
		Product productEntity = new Product();
		productEntity.setCategoryId(0);
		productEntity.setName(product.getName());
		productEntity.setSalePrice(product.getSalePrice());
		productEntity.setQuantity(product.getQuantity());
		productEntity.setDescription(product.getDescription());
		productEntity.setImage(product.getImage());
		
		int categoryId = product.getCategoryId();
		Category cat = categoryService.findById(categoryId);
		productEntity.setCategory(cat);
		
		productService.save(productEntity);
		
		return true;
	}
	
	/**
	 * Convert Product entity object to ProductModel object view
	 * 
	 * @param entity Product entity object
	 * @return ProductModel view bean
	 */
	private ProductModel convertEntityToModel(Product entity) {
		ProductModel productModel = new ProductModel(entity.getId()
				, entity.getName()
				, entity.getDescription()
				, entity.getPurchasePrice()
				, entity.getSalePrice()
				, entity.getImage()
				, entity.getCategory()
				, entity.getCode());
		productModel.setQuantity(entity.getQuantity());
		return productModel;
	}
	
	/**
	 * Get all categories of shop
	 * 
	 * @return list of categories
	 */
	public List<CategoryModel> getAllCategories() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		
		List<Category> categoriesEntity = categoryService.findAll();
		for (Category category : categoriesEntity) {
			CategoryModel catView = new CategoryModel(category.getId()
					, category.getCategoryName()
					, category.getCategoryCode()
					, category.getImage()
					, category.getDescription()
					, category.isActive() 
					);
			list.add(catView);
		}
         
        return list;
	}
	
	/**
	 * Get/find category by ID
	 * 
	 * @param id ID of category need to find
	 * @return
	 */
	public CategoryModel getCategoryById(int id) {
		Category categoriesEntity = categoryService.findById(id);
			CategoryModel catView = new CategoryModel(categoriesEntity.getId()
					, categoriesEntity.getCategoryName()
					, categoriesEntity.getCategoryCode()
					, categoriesEntity.getImage()
					, categoriesEntity.getDescription()
					, categoriesEntity.isActive()
					);
         
        return catView;
	}

	/**
	 * @return the cartAmount
	 */
	public double getCartAmount() {
		return cartAmount;
	}

	/**
	 * @param cartAmount the cartAmount to set
	 */
	public void setCartAmount(double cartAmount) {
		this.cartAmount = cartAmount;
	}

	/**
	 * @return the orderProductService
	 */
	public OrderProductService getOrderProductService() {
		return orderProductService;
	}

	/**
	 * @param orderProductService the orderProductService to set
	 */
	public void setOrderProductService(OrderProductService orderProductService) {
		this.orderProductService = orderProductService;
	}

	/**
	 * @return the customerService
	 */
	public CustomerService getCustomerService() {
		return customerService;
	}

	/**
	 * @param customerService the customerService to set
	 */
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * @return the categoryService
	 */
	public CategoryService getCategoryService() {
		return categoryService;
	}

	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * @return the productService
	 */
	public ProductService getProductService() {
		return productService;
	}

	/**
	 * @param productService the productService to set
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
}
