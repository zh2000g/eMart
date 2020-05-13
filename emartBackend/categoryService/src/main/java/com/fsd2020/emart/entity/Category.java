package com.fsd2020.emart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
    @Column(name = "category_name")
	private String categoryName;

    @Column(name = "brief_details")
	private String briefDetails;

    @Column(name = "parent_category_id")
	private int parentCategoryId;

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
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the briefDetails
	 */
	public String getBriefDetails() {
		return briefDetails;
	}

	/**
	 * @param briefDetails the briefDetails to set
	 */
	public void setBriefDetails(String briefDetails) {
		this.briefDetails = briefDetails;
	}

	/**
	 * @return the parentCategoryId
	 */
	public int getParentCategoryId() {
		return parentCategoryId;
	}

	/**
	 * @param parentCategoryId the parentCategoryId to set
	 */
	public void setParentCategoryId(int parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", briefDetails=" + briefDetails
				+ ", parentCategoryId=" + parentCategoryId + "]";
	}
	
}
