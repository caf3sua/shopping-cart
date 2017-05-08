/*
 * Copyright (c) 2015 Webware. All rights reserved.
 *
 */
package com.webware.persistence;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * Entity describing OrderProduct registered on the system.
 * 
 * @author Nam, Nguyen Hoai <hoainamtin2@gmail.com> 
 */
@Entity
@Table(name = "OrderProduct")
public class OrderProductEntity implements Serializable{
  
	/** Serialization id */
	private static final long serialVersionUID = 1L;
	  
	/** The OrderProduct id attribute */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OrderId")
	private Integer orderId;
	
	/** The OrderProduct UserId attribute */
	@Column(name = "UserId")
	private Integer userId;
	
	/** The OrderProduct OrderDate attribute */
	@Column(name = "OrderDate")
	private Timestamp orderDate;
	
	/** The OrderProduct OrderAmount attribute */
	@Column(name = "OrderAmount", columnDefinition = "Decimal(10,2)")
	private double orderAmount;
	
	/** The OrderProduct Discount attribute */
	@Column(name = "Discount")
	private Integer discount;
	
	/** The OrderProduct ShippingAmount attribute */
	@Column(name = "ShippingAmount", columnDefinition = "Decimal(10,2)")
	private double shippingAmount;
	
	/** The OrderProduct TaxAmount attribute */
	@Column(name = "TaxAmount", columnDefinition = "Decimal(10,2)")
	private double taxAmount;
	
	/** The OrderProduct NetAmount attribute */
	@Column(name = "NetAmount", columnDefinition = "Decimal(10,2)")
	private double netAmount;
	
	/** The OrderProduct ShippingDate attribute */
	@Column(name = "ShippingDate")
	private Timestamp shippingDate;
	
	/** The OrderProduct ShippingAddress attribute */
	@Column(name = "ShippingAddress")
	private String shippingAddress;
	
	/** The OrderProduct BillingAddress attribute */
	@Column(name = "BillingAddress")
	private String billingAddress;
	
	/** The OrderProduct StatusId attribute */
	@Column(name = "StatusId")
	private Integer statusId;
	
	/** The OrderProduct active attribute */
	@Column(name = "Active", nullable = false, columnDefinition = "TINYINT(1)")
	private boolean active;
	
	@OneToMany(mappedBy="orderProduct", fetch=FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Set<OrderDetailEntity> listOrderDetail;
	
	/**
	 * Constructor method
	 */
	public OrderProductEntity(){
		
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
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the orderDate
	 */
	public Timestamp getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the orderAmount
	 */
	public double getOrderAmount() {
		return orderAmount;
	}

	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
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
	 * @return the shippingAmount
	 */
	public double getShippingAmount() {
		return shippingAmount;
	}

	/**
	 * @param shippingAmount the shippingAmount to set
	 */
	public void setShippingAmount(double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	/**
	 * @return the taxAmount
	 */
	public double getTaxAmount() {
		return taxAmount;
	}

	/**
	 * @param taxAmount the taxAmount to set
	 */
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	/**
	 * @return the netAmount
	 */
	public double getNetAmount() {
		return netAmount;
	}

	/**
	 * @param netAmount the netAmount to set
	 */
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	/**
	 * @return the shippingDate
	 */
	public Timestamp getShippingDate() {
		return shippingDate;
	}

	/**
	 * @param shippingDate the shippingDate to set
	 */
	public void setShippingDate(Timestamp shippingDate) {
		this.shippingDate = shippingDate;
	}

	/**
	 * @return the shippingAddress
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * @return the billingAddress
	 */
	public String getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
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

	/**
	 * @return the listOrderDetail
	 */
	public Set<OrderDetailEntity> getListOrderDetail() {
		return listOrderDetail;
	}

	/**
	 * @param listOrderDetail the listOrderDetail to set
	 */
	public void setListOrderDetail(Set<OrderDetailEntity> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}

	
	
}
