/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.view.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.webware.controller.ShopController;
import com.webware.model.CategoryModel;
import com.webware.model.ProductModel;
import com.webware.utils.ShopProperty;

/**
 * ManagedBean is an main class responsible 
 * for actions related to view/action of admin module
 *   
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com>
 */
@ManagedBean(name = "adminView")
@ViewScoped
public class DataGridAdminView implements Serializable {
	/** Log instance */
	private static final Log LOG = LogFactory.getLog(DataGridAdminView.class);
    
	/** Default serial */
	private static final long serialVersionUID = 880644599674059195L;

	/** categories property */
	private List<CategoryModel> categories;
    
	/** selectedCatefory property */
    private CategoryModel selectedCatefory;
    
    /** products property */
	private List<ProductModel> products;
    
	/** selectedProduct property */
    private ProductModel selectedProduct;
    
    /** addProduct property */
    private ProductModel addProduct = new ProductModel();
    
    /** selectedCategory property */
    private CategoryModel selectedCategory;
    
    /** selectCategoryList property */
    private List<SelectItem> selectCategoryList;

    /** selectedCategoryId property */
    @ManagedProperty("#{param.selectedCategoryId}")
    private int selectedCategoryId = -1;
    
    /** shopController instance */
    @ManagedProperty("#{shop}")
    private ShopController shopController;
    
    /** imageProductFolderPath property */
    private String imageProductFolderPath;
     
    /**
     * Init the ManagedBean
     * <li>Get and set all categories</li>
     * <li>Get and set all products</li>
     * <li>Get and set image path</li>
     */
    @PostConstruct
    public void init() {
    	// Get all categories
    	setCategories(shopController.getAllCategories());
    	// Get all product
    	getAllProduct();
    	
    	String imageFolder = ShopProperty.loadPropertiesByKey("images.upload.dir") + "product/";
    	setImageProductFolderPath(imageFolder);
    }

    /**
     * Go to add product page (/admin/add-product.xhtml)
     * 
     * @return FacesContext navigator
     */
    public String gotoAddProductPage() {
    	addProduct = new ProductModel();
		return "add-product";
	}
    
    /**
     * Go to main admin page (/admin/main-admin.xhtml)
     * 
     * @return FacesContext navigator
     */
    public String backToMainAdmin() {
		return "main-admin";
	}

    /**
     * Get all product and set into properties
     */
    public void getAllProduct() {
    	LOG.debug("getAllProduct start");
    	
    	setProducts(shopController.getAllProduct());
    }
    
    /**
     * Add product action (used by admin backend)
     * 
     * @return FacesContext navigator
     */
    public String addProductAdmin() {
    	LOG.debug("saveProductAdmin");
    	
    	// Update product
    	shopController.addProduct(addProduct);
    	
    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Add success!",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    	RequestContext requestContext = RequestContext.getCurrentInstance();
    	requestContext.update("messages");
    	
		return "success";
    }
    
    /**
     * Update product action (used by admin backend)
     * 
     * @return FacesContext navigator
     */
    public String updateProductAdmin(ProductModel productModel) {
    	LOG.debug("updateProductAdmin Start, order" + productModel);
    	
    	// Update product
    	shopController.updateProduct(productModel);
    	
    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Update success!",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        // Disable update
    	productModel.setDisableUpdate(true);
    	
    	RequestContext requestContext = RequestContext.getCurrentInstance();
    	requestContext.update("messages");
    	
		return null;
    }
    
    /**
     * Toggle/enable edit product function
     * 
     * @param ProductModel view object will be updated
     * @return FacesContext navigator
     */
    public String enableEditProductAdmin(ProductModel productModel) {
    	LOG.debug("enableEditProductAdmin Start, product" + productModel);
    	
    	// Enable update
    	productModel.setDisableUpdate(false);
    	
    	selectedProduct = productModel;
    	LOG.debug("enableEditProductAdmin, product" + productModel.getId());
    	
		return null;
    }
    
    /**
     * Delete product action (used by admin backend)
     * 
     * @return FacesContext navigator
     */
    public String deleteProduct(ProductModel product) {
    	LOG.debug("removeCartOrder Start");
    	
		// Delete product
    	shopController.deleteProduct(product.getId());
    	
    	// Reload
    	
    	LOG.debug("selectedCategory: " + selectedCategory);
    	if (selectedCategoryId != -1) {
    		setProducts(shopController.getAllProduct());
    		
    	} else {
    		setProducts(shopController.getProductByCategoryId(selectedCategoryId));
    	}
    	
    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete success!",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    	RequestContext requestContext = RequestContext.getCurrentInstance();
    	requestContext.update("messages");
		
		return null;
    }
    
    /**
     * Get all product by category ID
     * 
     */
    public void getProductByCategoryId() {
    	LOG.debug("selectedCategory: " + selectedCategory);
    	setProducts(shopController.getProductByCategoryId(selectedCategoryId));
    	setSelectedCategory(shopController.getCategoryById(selectedCategoryId));
    }

    /**
     * Handle file upload, save them to disk
     * 
     * @param event FileUploadEvent
     */
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        UploadedFile file = event.getFile();
        try{
        	String filename = System.currentTimeMillis() + "_" + file.getFileName();
        	String fullFile = getImageProductFolderPath() + filename;
        	LOG.debug("fileName: " + fullFile);
            FileOutputStream fos = new FileOutputStream(new File(fullFile));
            InputStream is = file.getInputstream();
            int BUFFER_SIZE = 8192;
            byte[] buffer = new byte[BUFFER_SIZE];
            int a;
            while(true){
                a = is.read(buffer);
                if(a < 0) break;
                fos.write(buffer, 0, a);
                fos.flush();
            }
            fos.close();
            is.close();
            
            // Get productID
            Integer productID = (Integer) event.getComponent().getAttributes().get("productID");
            
            // Update the product
            shopController.updateProductImage(productID, filename);
            
            // Update view
            List<ProductModel> listProduct = shopController.getAllProduct();
            getProducts().clear();
            getProducts().addAll(listProduct);
            
            RequestContext requestContext = RequestContext.getCurrentInstance();
        	requestContext.update("dtProducts");
        }catch(IOException e){
        	LOG.debug(e.getMessage());
        }
        
    }
    
    /**
     * Handle file upload, save them to disk
     * 
     * @param event FileUploadEvent
     */
    public void handleFileUploadAddProduct(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        UploadedFile file = event.getFile();
        try{
        	String filename = System.currentTimeMillis() + "_" + file.getFileName();
        	String fullFile = getImageProductFolderPath() + filename;
        	LOG.debug("fileName: " + fullFile);
            FileOutputStream fos = new FileOutputStream(new File(fullFile));
            InputStream is = file.getInputstream();
            int BUFFER_SIZE = 8192;
            byte[] buffer = new byte[BUFFER_SIZE];
            int a;
            while(true){
                a = is.read(buffer);
                if(a < 0) break;
                fos.write(buffer, 0, a);
                fos.flush();
            }
            fos.close();
            is.close();
            
            // Update the product
            ProductModel productModel = getAddProduct();
            productModel.setImage(filename);
            LOG.debug("add productModel: " + productModel);
            
            RequestContext requestContext = RequestContext.getCurrentInstance();
        	requestContext.update("imageProduct");
        	requestContext.update("add-product:inputImage");
        }catch(IOException e){
        	LOG.debug(e.getMessage());
        }
    }
    
	/**
	 * @return the products
	 */
	public List<ProductModel> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	/**
	 * @return the selectedProduct
	 */
	public ProductModel getSelectedProduct() {
		return selectedProduct;
	}

	/**
	 * @param selectedProduct the selectedProduct to set
	 */
	public void setSelectedProduct(ProductModel selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	/**
	 * @return the selectedCategory
	 */
	public CategoryModel getSelectedCategory() {
		return selectedCategory;
	}

	/**
	 * @param selectedCategory the selectedCategory to set
	 */
	public void setSelectedCategory(CategoryModel selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	/**
	 * @return the selectedCategoryId
	 */
	public int getSelectedCategoryId() {
		return selectedCategoryId;
	}

	/**
	 * @param selectedCategoryId the selectedCategoryId to set
	 */
	public void setSelectedCategoryId(int selectedCategoryId) {
		this.selectedCategoryId = selectedCategoryId;
	}

	/**
	 * @return the shopController
	 */
	public ShopController getShopController() {
		return shopController;
	}

	/**
	 * @param shopController the shopController to set
	 */
	public void setShopController(ShopController shopController) {
		this.shopController = shopController;
	}

	/**
	 * @return the selectCategoryList
	 */
	public List<SelectItem> getSelectCategoryList() {
		selectCategoryList = new ArrayList<SelectItem>();
        
        List<CategoryModel> categories = shopController.getAllCategories();
        for (CategoryModel categoryModel : categories) {
			selectCategoryList.add(new SelectItem(categoryModel.getId(), categoryModel.getName()));
		}
        
		return selectCategoryList;
	}

	/**
	 * @param selectCategoryList the selectCategoryList to set
	 */
	public void setSelectCategoryList(List<SelectItem> selectCategoryList) {
		this.selectCategoryList = selectCategoryList;
	}

	/**
	 * @return the categories
	 */
	public List<CategoryModel> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<CategoryModel> categories) {
		this.categories = categories;
	}

	/**
	 * @return the selectedCatefory
	 */
	public CategoryModel getSelectedCatefory() {
		return selectedCatefory;
	}

	/**
	 * @param selectedCatefory the selectedCatefory to set
	 */
	public void setSelectedCatefory(CategoryModel selectedCatefory) {
		this.selectedCatefory = selectedCatefory;
	}

	/**
	 * @return the addProduct
	 */
	public ProductModel getAddProduct() {
		return addProduct;
	}

	/**
	 * @param addProduct the addProduct to set
	 */
	public void setAddProduct(ProductModel addProduct) {
		this.addProduct = addProduct;
	}

	/**
	 * @return the imageProductFolderPath
	 */
	public String getImageProductFolderPath() {
		return imageProductFolderPath;
	}

	/**
	 * @param imageProductFolderPath the imageProductFolderPath to set
	 */
	public void setImageProductFolderPath(String imageProductFolderPath) {
		this.imageProductFolderPath = imageProductFolderPath;
	}
	 
}