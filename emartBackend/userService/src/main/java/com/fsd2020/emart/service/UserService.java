package com.fsd2020.emart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd2020.emart.entity.Buyer;
import com.fsd2020.emart.entity.Seller;
import com.fsd2020.emart.repository.BuyerRepository;
import com.fsd2020.emart.repository.SellerRepository;

@Service
public class UserService {
	
	@Autowired
	BuyerRepository buyerRepository;
	
	@Autowired
	SellerRepository sellerRepository;

	/**
	 * Get Buyer
	 * @param userId Buyer ID
	 * @return Buyer
	 */
	public Buyer getBuyer(String userId) {
		
		List<Buyer> list = buyerRepository.findByUserId(userId);
		
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	/**
	 * Get Seller
	 * @param userId Seller ID
	 * @return Seller
	 */
	public Seller getSeller(String userId) {
		
		List<Seller> list = sellerRepository.findByUserId(userId);
		
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	/**
	 * 
	 * @param buyer
	 * @return true:success false:failure
	 */
	public boolean buyerSignUp(Buyer buyer) {
		if(buyerRepository.save(buyer) !=null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param seller
	 * @return true:success false:failure
	 */
	public boolean sellerSignUp(Seller seller) {
		if(sellerRepository.save(seller) !=null) {
			return true;
		} else {
			return false;
		}
	}
}
