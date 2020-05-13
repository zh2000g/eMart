package com.fsd2020.emart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2020.emart.entity.Item;
import com.fsd2020.emart.service.ItemService;

@RestController
public class ItemServiceControler {
	@Autowired
	ItemService itemService;
	
	@RequestMapping("/getListBySeller")
	public List<Item> getListBySeller(String seller) {
		return itemService.getItemListBySeller(seller);
	}
	
	@RequestMapping("/getListByCategory")
	public List<Item> getListByCategory(int categoryId, int subCategoryId) {
		return itemService.getItemListByCategory(categoryId, subCategoryId);
	}
	
	@RequestMapping("/getItemName")
	public String getItemName(int id) {
		Item item = itemService.getItem(id);
		
		if (item != null) {
			return item.getItemName();
		} else {
			return "";
		}	
	}
	
	@RequestMapping("/getItemImageUrl")
	public String[] getItemImageUrl(int id) {
		
		String[] urlList = new String[4];
		
		Item item = itemService.getItem(id);
		
		if (item != null) {
			urlList[0] = item.getImageUrl1();
			urlList[1] = item.getImageUrl2();
			urlList[2] = item.getImageUrl3();
			urlList[3] = item.getImageUrl4();
		}
		
		return urlList;
	}
	
	@RequestMapping("/addItem")
	public void addItem(Item item) {
		itemService.addItem(item);
	}
}
