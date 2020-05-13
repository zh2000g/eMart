package com.fsd2020.emart.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deal")
public class Deal implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
    @Column(name = "item_id")
	private String itemId;
    
    @Column(name = "item_name")
	private String itemName;

    @Column(name = "category_id")
	private int categoryId;

    @Column(name = "sub_category_id")
	private int subCategoryId;

    @Column(name = "seller")
	private String seller;
    
    @Column(name = "buyer")
	private String buyer;

    @Column(name = "price")
	private double price;

    @Column(name = "purchase_num")
	private int purchaseNum;

    @Column(name = "purchase_time")
	private Date purchaseTime;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the subCategoryId
	 */
	public int getSubCategoryId() {
		return subCategoryId;
	}

	/**
	 * @param subCategoryId the subCategoryId to set
	 */
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	/**
	 * @return the seller
	 */
	public String getSeller() {
		return seller;
	}

	/**
	 * @param seller the seller to set
	 */
	public void setSeller(String seller) {
		this.seller = seller;
	}

	/**
	 * @return the buyer
	 */
	public String getBuyer() {
		return buyer;
	}

	/**
	 * @param buyer the buyer to set
	 */
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the purchaseNum
	 */
	public int getPurchaseNum() {
		return purchaseNum;
	}

	/**
	 * @param purchaseNum the purchaseNum to set
	 */
	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	/**
	 * @return the purchaseTime
	 */
	public Date getPurchaseTime() {
		return purchaseTime;
	}

	/**
	 * @param purchaseTime the purchaseTime to set
	 */
	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "Deal [id=" + id + ", itemId=" + itemId + ", itemName=" + itemName + ", categoryId=" + categoryId
				+ ", subCategoryId=" + subCategoryId + ", seller=" + seller + ", buyer=" + buyer + ", price=" + price
				+ ", purchaseNum=" + purchaseNum + ", purchaseTime=" + purchaseTime + "]";
	}
}
