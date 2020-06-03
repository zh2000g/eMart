package com.fsd2020.emart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
    @Column(name = "item_name")
	private String itemName;

    @Column(name = "category_id")
	private int categoryId;

    @Column(name = "sub_category_id")
	private int subCategoryId;

    @Column(name = "seller")
	private String seller;

    @Column(name = "price")
	private double price;

    @Column(name = "remain_num")
	private int remainNum;
    
    @Column(name = "item_desc")
	private String itemDesc;

	@Column(name = "image_url_1")
	private String imageUrl1;

    @Column(name = "image_url_2")
	private String imageUrl2;

    @Column(name = "image_url_3")
	private String imageUrl3;

    @Column(name = "image_url_4")
	private String imageUrl4;

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
	 * @return the remainNum
	 */
	public int getRemainNum() {
		return remainNum;
	}

	/**
	 * @param remainNum the remainNum to set
	 */
	public void setRemainNum(int remainNum) {
		this.remainNum = remainNum;
	}

	/**
	 * @return the imageUrl1
	 */
	public String getImageUrl1() {
		return imageUrl1;
	}

	/**
	 * @param imageUrl1 the imageUrl1 to set
	 */
	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}

	/**
	 * @return the imageUrl2
	 */
	public String getImageUrl2() {
		return imageUrl2;
	}

	/**
	 * @param imageUrl2 the imageUrl2 to set
	 */
	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}

	/**
	 * @return the imageUrl3
	 */
	public String getImageUrl3() {
		return imageUrl3;
	}

	/**
	 * @param imageUrl3 the imageUrl3 to set
	 */
	public void setImageUrl3(String imageUrl3) {
		this.imageUrl3 = imageUrl3;
	}

	/**
	 * @return the imageUrl4
	 */
	public String getImageUrl4() {
		return imageUrl4;
	}

	/**
	 * @param imageUrl4 the imageUrl4 to set
	 */
	public void setImageUrl4(String imageUrl4) {
		this.imageUrl4 = imageUrl4;
	}
	
    /**
	 * @return the remainDesc
	 */
	public String getItemDesc() {
		return itemDesc;
	}

	/**
	 * @param remainDesc the remainDesc to set
	 */
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", categoryId=" + categoryId + ", subCategoryId="
				+ subCategoryId + ", seller=" + seller + ", price=" + price + ", remainNum=" + remainNum
				+ ", imageUrl1=" + imageUrl1 + ", imageUrl2=" + imageUrl2 + ", imageUrl3=" + imageUrl3 + ", imageUrl4="
				+ imageUrl4 + "]";
	}
}
