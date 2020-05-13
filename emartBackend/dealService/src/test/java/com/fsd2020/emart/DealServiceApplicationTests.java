package com.fsd2020.emart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fsd2020.emart.entity.Deal;
import com.fsd2020.emart.service.DealService;

@SpringBootTest
class DealServiceApplicationTests {
	
	@Autowired
	DealService dealService;

	@Test
	void getDealListByBuyerTest() {
		List<Deal> list =  dealService.getDealListByBuyer("buyer1");
	       System.out.println(String.format("getDealListByBuyerTest test result is: %s", list.toString()));
	}
	
	@Test
	void getDealListBySellerTest() {
		List<Deal> list =  dealService.getDealListBySeller("seller1");
	       System.out.println(String.format("getDealListBySellerTest test result is: %s", list.toString()));
	}


}
