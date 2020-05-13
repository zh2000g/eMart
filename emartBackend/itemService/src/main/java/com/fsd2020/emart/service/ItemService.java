package com.fsd2020.emart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd2020.emart.entity.Item;
import com.fsd2020.emart.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;

	/**
	 * Get Item Name
	 * @param itemId Item ID
	 * @return Item
	 */
	public Item getItem(int itemId) {
		
		return itemRepository.getOne(itemId);
	}
	
	/**
	 * Get Item List of Seller
	 * @param seller
	 * @return Item List
	 */
	public List<Item> getItemListBySeller(String seller) {
		
		List<Item> list = itemRepository.findBySeller(seller);
		
		return list;
	}
	
	/**
	 * get Item List of SubCategory
	 * @param categoryId Category ID
	 * @param subCategoryId SubCategory ID
	 * @return Item List
	 */
	public List<Item> getItemListByCategory(int categoryId, int subCategoryId) {
			
		List<Item> list = itemRepository.findByCategoryIdAndSubCategoryId(categoryId, subCategoryId);
		
		return list;
	}
	
	/**
	 * 
	 * @param item Item
	 * @return true:success false:failure
	 */
	public boolean addItem(Item item) {
		if(itemRepository.save(item) !=null) {
			return true;
		} else {
			return false;
		}
	}

}
