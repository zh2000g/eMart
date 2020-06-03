package com.fsd2020.emart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2020.emart.entity.Item;
import com.fsd2020.emart.service.ItemService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/item")
public class ItemServiceControler {
	@Autowired
	ItemService itemService;
	
	@RequestMapping("/getListBySeller")
	public Item[] getListBySeller(String sellerId) {
		List<Item> list = itemService.getItemListBySeller(sellerId);
		return list.toArray(new Item[list.size()]);
	}
	
	@RequestMapping("/getListByName")
	public Item[] getListByName(String itemName) {
		List<Item> list = itemService.getItemListByName(itemName);
		return list.toArray(new Item[list.size()]);
	}
	
	@RequestMapping("/getListByCategory")
	public Item[] getListByCategory(int categoryId, int subCategoryId) {
		List<Item> list = itemService.getItemListByCategory(categoryId, subCategoryId);
		return list.toArray(new Item[list.size()]);
		
	}
	
	@RequestMapping("/getItemById")
	public Item getItemById(int id) {
		Item item = itemService.getItem(id);
		return item;
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
	
	@PostMapping("/addItem")
	public boolean addItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}
}
