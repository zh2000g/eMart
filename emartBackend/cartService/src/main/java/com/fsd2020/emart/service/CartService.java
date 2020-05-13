package com.fsd2020.emart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd2020.emart.entity.CartItem;
import com.fsd2020.emart.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;

	/**
	 * get CartItemList of Buyer
	 * @param buyer Buyer ID
	 * @return CartItemList
	 */
	public List<CartItem> getCartItemListByBuyer(String buyer) {
		
		List<CartItem> list = cartRepository.findByBuyer(buyer);
		
		return list;
	}
	
	/**
	 * 
	 * @param cartItem
	 * @return true:success false:failure
	 */
	public boolean addItem(CartItem cartItem) {
		if(cartRepository.save(cartItem) !=null) {
			return true;
		} else {
			return false;
		}
	}
	

}
