package com.fsd2020.emart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2020.emart.entity.Buyer;
import com.fsd2020.emart.entity.Seller;

import com.fsd2020.emart.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserServiceControler {
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
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
	
	@GetMapping("/getBuyer")
	public Buyer getBuyer(String userId) {
		
		return userService.getBuyer(userId);
	}
	
	
	@GetMapping("/getSeller")
	public Seller getSeller(String userId) {
		
		return userService.getSeller(userId);
	}
	

	@PostMapping("/sellerSignUp")
	public boolean sellerSignUp(@RequestBody Seller seller) {
		
		return userService.sellerSignUp(seller);
	}
	
	
	@PostMapping("/buyerSignUp")
	public boolean buyerSignUp(@RequestBody Buyer buyer) {
		
		return userService.buyerSignUp(buyer);
	}
	
}
