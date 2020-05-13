package com.fsd2020.emart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2020.emart.entity.Deal;
import com.fsd2020.emart.service.DealService;

@RestController
public class DealServiceControler {
	@Autowired
	DealService dealService;
	
	@RequestMapping("/getPurchaseHistory")
	public List<Deal> getDealListByBuyer(String buyer) {
		return dealService.getDealListByBuyer(buyer);
	}

	@RequestMapping("/getSellHistory")
	public List<Deal> getDealListBySeller(String seller) {
		return dealService.getDealListBySeller(seller);
	}
	
	@RequestMapping("/addDeal")
	public void addItem(Deal deal) {
		dealService.addDeal(deal);
	}
}
