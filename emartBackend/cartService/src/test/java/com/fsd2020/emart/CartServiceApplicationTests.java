package com.fsd2020.emart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fsd2020.emart.entity.CartItem;
import com.fsd2020.emart.service.CartService;

@SpringBootTest
class CartServiceApplicationTests {

    @Autowired
    private CartService cartService;
    
	@Test
	void getCartItemListTest() {
		List<CartItem> list = cartService.getCartItemListByBuyer("buyer1");
        System.out.println(String.format("getCartItemListTest test result is: %s", list.toString()));
	}

}
