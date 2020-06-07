package com.fsd2020.emart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2020.emart.entity.Deal;
import com.fsd2020.emart.service.DealService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/deal")
public class DealServiceControler {
	@Autowired
	DealService dealService;
	
	@RequestMapping("/getDealListByBuyer")
	public List<Deal> getDealListByBuyer(String buyer) {
		return dealService.getDealListByBuyer(buyer);
	}

	@RequestMapping("/getDealListBySeller")
	public List<Deal> getDealListBySeller(String seller) {
		return dealService.getDealListBySeller(seller);
	}
	
	@PostMapping("/addDeal")
	public boolean addItem(@RequestBody Deal deal) {
		return dealService.addDeal(deal);
	}
}
