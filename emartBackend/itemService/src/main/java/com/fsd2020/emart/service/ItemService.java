package com.fsd2020.emart.service;

import java.util.ArrayList;
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
	 * Get Item Object
	 * @param id Item ID
	 * @return Item
	 */
	public Item getItem(int id) {

		return itemRepository.findById(id)
				.orElse(new Item());
	}
	
	/**
	 * Get Item List of Seller
	 * @param seller
	 * @return Item List
	 */
	public List<Item> getItemListBySeller(String sellerId) {
		
		List<Item> list = itemRepository.findBySeller(sellerId);
		
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
	 * get Item List of SubCategory
	 * @param categoryId Category ID
	 * @param subCategoryId SubCategory ID
	 * @return Item List
	 */
	public List<Item> getItemListByName(String itemName) {
			
		List<Object[]> list = itemRepository.findByItemNameLike(itemName);
		List<Item> returnList = new ArrayList<Item>();
		
		for (Object[] objects : list) {
			Item item = new Item();
			item.setId((int)objects[0]);
			item.setItemName((String)objects[1]);
			item.setCategoryId((int)objects[2]);
			item.setSubCategoryId((int)objects[3]);
			item.setSeller((String)objects[4]);
			item.setPrice((double)objects[5]);
			item.setRemainNum((int)objects[6]);
			item.setItemDesc((String)objects[7]);
			
			returnList.add(item);
		}
		
		return returnList;
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
