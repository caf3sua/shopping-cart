/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity describing OrderDetail registered on the system.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com> 
 */
@Entity
@Table(name = "OrderDetail", uniqueConstraints = {
		@UniqueConstraint(columnNames = "OrderId")} )
public class OrderDetailEntity implements Serializable{
  
	/** Serialization id */
	private static final long serialVersionUID = 1L;
	
	/** The OrderDetail id attribute */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Integer Id;
	
	/** The OrderDetail orderId attribute */
	@Column(name = "OrderId")
	private Integer orderId;
	
	/** The OrderDetail productId attribute */
	@Column(name = "ProductId")
	private Integer productId;
	
	/** The OrderDetail productPrice attribute */
	@Column(name = "ProductPrice", columnDefinition = "Decimal(10,2)")
	private double productPrice;
	
	/** The OrderDetail quantity attribute */
	@Column(name = "Quantity")
	private long quantity;
	
	/** The OrderDetail discount attribute */
	@Column(name = "Discount")
	private Integer discount;
	
	/** The OrderDetail active attribute */
	@Column(name = "Active", nullable = false, columnDefinition = "TINYINT(1)")
	private boolean active;
	
	@ManyToOne
    @JoinColumn(name="OrderId",referencedColumnName="OrderId", insertable=false, updatable=false)
	private OrderProductEntity orderProduct;

	/**
	 * Constructor method
	 */
	public OrderDetailEntity(){
		
	}
	
	/**
	 * @return the orderProduct
	 */
	public OrderProductEntity getOrderProduct() {
		return orderProduct;
	}

	/**
	 * @param orderProduct the orderProduct to set
	 */
	public void setOrderProduct(OrderProductEntity orderProduct) {
		this.orderProduct = orderProduct;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * @return the orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the quantity
	 */
	public long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the discount
	 */
	public Integer getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	
}
