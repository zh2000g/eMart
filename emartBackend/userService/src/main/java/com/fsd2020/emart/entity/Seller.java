package com.fsd2020.emart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seller")
public class Seller implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
	@Column(name = "user_id")
	private String userId;

    @Column(name = "user_name")
	private String userName;
    
    @Column(name = "password")
	private String password;
    
    @Column(name = "company_name")
	private String companyName;
    
    @Column(name = "brief_of_company")
	private String briefOfCompany;

    @Column(name = "gstin")
	private String gstin;

    @Column(name = "post_address")
	private String postAddress;

    @Column(name = "website")
	private String website;

    @Column(name = "email")
	private String email;

    @Column(name = "contract_number")
	private String contractNumber;

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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the briefOfCompany
	 */
	public String getBriefOfCompany() {
		return briefOfCompany;
	}

	/**
	 * @param briefOfCompany the briefOfCompany to set
	 */
	public void setBriefOfCompany(String briefOfCompany) {
		this.briefOfCompany = briefOfCompany;
	}

	/**
	 * @return the gstin
	 */
	public String getGstin() {
		return gstin;
	}

	/**
	 * @param gstin the gstin to set
	 */
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	/**
	 * @return the postAddress
	 */
	public String getPostAddress() {
		return postAddress;
	}

	/**
	 * @param postAddress the postAddress to set
	 */
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contractNumber
	 */
	public String getContractNumber() {
		return contractNumber;
	}

	/**
	 * @param contractNumber the contractNumber to set
	 */
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	/* 
	 * toString
	 */
	@Override
	public String toString() {
		return "Seller [id=" + id + ", userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", companyName=" + companyName + ", briefOfCompany=" + briefOfCompany + ", gstin=" + gstin
				+ ", postAddress=" + postAddress + ", website=" + website + ", email=" + email + ", contractNumber="
				+ contractNumber + "]";
	}
	

}
