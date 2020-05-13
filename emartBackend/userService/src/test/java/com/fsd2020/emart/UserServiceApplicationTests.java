package com.fsd2020.emart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fsd2020.emart.entity.Buyer;
import com.fsd2020.emart.entity.Seller;
import com.fsd2020.emart.service.UserService;

@SpringBootTest
class UserServiceApplicationTests {
	
	@Autowired
	UserService userService;

	@Test
	void getBuyerTest() {
		Buyer buyer = userService.getBuyer("buyer1");
	    System.out.println(String.format("getBuyerTest test result is: %s", buyer.toString()));
	}

	@Test
	void getSellerTest() {
		Seller seller = userService.getSeller("seller1");
	    System.out.println(String.format("getBuyerTest test result is: %s", seller.toString()));
	}

}
