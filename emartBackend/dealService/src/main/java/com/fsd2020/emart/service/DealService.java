package com.fsd2020.emart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd2020.emart.entity.Deal;
import com.fsd2020.emart.repository.DealRepository;

@Service
public class DealService {
	
	@Autowired
	DealRepository dealRepository;

	/**
	 * return Deal History of Buyer
	 * @param buyer： Buyer's ID
	 * @return Deal History
	 */
	public List<Deal> getDealListByBuyer(String buyer) {
		
		List<Deal> list = dealRepository.findByBuyerOrderByPurchaseTimeDesc(buyer);
		
		return list;
	}

	/**
	 * return Deal History of Seller
	 * @param seller
	 * @return Deal History
	 */
	public List<Deal> getDealListBySeller(String seller) {
		
		List<Deal> list = dealRepository.findBySellerOrderByPurchaseTimeDesc(seller);
		
		return list;
	}

	/**
	 * 
	 * @param deal
	 * @return true:success false:failure
	 */
	public boolean addDeal(Deal deal) {
		if(dealRepository.save(deal) !=null) {
			return true;
		} else {
			return false;
		}
	}
}
