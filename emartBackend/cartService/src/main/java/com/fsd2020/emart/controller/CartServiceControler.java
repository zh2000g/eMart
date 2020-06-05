package com.fsd2020.emart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2020.emart.entity.CartItem;
import com.fsd2020.emart.service.CartService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cart")
public class CartServiceControler {
	@Autowired
	CartService cartService;
	
	@RequestMapping("/getCartItemListByBuyer")
	public CartItem[] getCartItemListByBuyer(String buyer) {
		List<CartItem> list = cartService.getCartItemListByBuyer(buyer);
		return list.toArray(new CartItem[list.size()]);
	}
	
	@PostMapping("/addCartItem")
	public boolean addCartItem(@RequestBody CartItem cartItem) {
		return cartService.addCartItem(cartItem);
	}
	
	@RequestMapping("/delCartItem")
	public boolean delCartItem(int id) {
		return cartService.delCartItem(id);
	}
}
