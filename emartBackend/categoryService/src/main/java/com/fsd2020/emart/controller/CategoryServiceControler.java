package com.fsd2020.emart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd2020.emart.entity.Category;
import com.fsd2020.emart.service.CategoryService;

@RestController
public class CategoryServiceControler {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/getCategoryName")
	public String getCategoryName(int id) {
		return categoryService.getCategoryName(id);
	}
	
	@RequestMapping("/getList")
	public List<Category> getCategoryList() {
		return categoryService.getCategoryList();
	}
	
	@RequestMapping("/getSubList")
	public List<Category> getSubCategoryList(int parentCategoryId) {
		return categoryService.getSubCategoryList(parentCategoryId);
	}

}
