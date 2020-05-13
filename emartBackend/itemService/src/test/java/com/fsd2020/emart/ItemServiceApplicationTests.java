package com.fsd2020.emart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fsd2020.emart.entity.Item;
import com.fsd2020.emart.service.ItemService;

@SpringBootTest
class ItemServiceApplicationTests {
	
	@Autowired
	ItemService itemService;

	@Test
	@Transactional
	void getItemTest() {
		Item item = itemService.getItem(1);
	    System.out.println(String.format("getItemTest test result is: %s", item));

	}
	
	@Test
	@Transactional
	void getItemListBySellerTest() {
		List<Item> list = itemService.getItemListBySeller("seller1");
	    System.out.println(String.format("getItemListBySellerTest test result is: %s", list.toString()));
	}
	
	@Test
	@Transactional
	void getItemListByCategoryTest() {
		List<Item> list = itemService.getItemListByCategory(1, 5);
	    System.out.println(String.format("getItemListByCategoryTest test result is: %s", list.toString()));
	}

}
