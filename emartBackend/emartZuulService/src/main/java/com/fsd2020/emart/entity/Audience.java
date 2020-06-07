package com.fsd2020.emart.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Audience implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String clientId = "client";
    private String base64Secret = "fsd2020";
    private String name = "FSD2020";
    private int expiresSecond = 259200;
    
    /**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the base64Secret
	 */
	public String getBase64Secret() {
		return base64Secret;
	}
	/**
	 * @param base64Secret the base64Secret to set
	 */
	public void setBase64Secret(String base64Secret) {
		this.base64Secret = base64Secret;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the expiresSecond
	 */
	public int getExpiresSecond() {
		return expiresSecond;
	}
	/**
	 * @param expiresSecond the expiresSecond to set
	 */
	public void setExpiresSecond(int expiresSecond) {
		this.expiresSecond = expiresSecond;
	}
}
