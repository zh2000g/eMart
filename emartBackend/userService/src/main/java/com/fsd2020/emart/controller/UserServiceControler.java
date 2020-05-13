package com.fsd2020.emart.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2020.emart.entity.Buyer;
import com.fsd2020.emart.entity.Seller;

import com.fsd2020.emart.service.UserService;

@RestController
public class UserServiceControler {
	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	public boolean login(int userKind, String userId, String password) {
		
		if(userKind == 1) {
			// userKind=1(buyer)
			Buyer buyer = userService.getBuyer(userId);
			
			if(buyer != null) {
				if(password.equals(buyer.getPassword())) {
					return true;
				}
			}
		} else {
			// userKind=2(seller)
			Seller seller = userService.getSeller(userId);
			
			if(seller != null) {
				if(password.equals(seller.getPassword())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@RequestMapping("/getUserName")
	public String getUserName(int userKind, String userId) {
		
		String userName = "";
		
		if(userKind == 1) {
			// userKind=1(buyer)
			Buyer buyer = userService.getBuyer(userId);
			
			if(buyer != null) {
				userName = buyer.getUserName();
			}
		} else {
			// userKind=2(seller)
			Seller seller = userService.getSeller(userId);
			
			if(seller != null) {
				userName = seller.getUserName();
			}
		}
		
		return userName;
	}
	
}
