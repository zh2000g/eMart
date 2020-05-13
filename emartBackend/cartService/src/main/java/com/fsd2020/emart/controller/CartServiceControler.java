package com.fsd2020.emart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2020.emart.entity.CartItem;
import com.fsd2020.emart.service.CartService;

@RestController
public class CartServiceControler {
	@Autowired
	CartService cartService;
	
	@RequestMapping("/getCartItemListByBuyer")
	public List<CartItem> getCartItemListByBuyer(String buyer) {
		return cartService.getCartItemListByBuyer(buyer);
	}
	
	@RequestMapping("/addCartItem")
	public void addItem(CartItem cartItem) {
		cartService.addItem(cartItem);
	}
}
