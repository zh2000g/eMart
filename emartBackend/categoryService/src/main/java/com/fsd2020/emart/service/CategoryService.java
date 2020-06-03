package com.fsd2020.emart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fsd2020.emart.entity.Category;
import com.fsd2020.emart.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	/**
	 * get Category Name
	 * @param categoryId
	 * @return
	 */
	public String getCategoryName(int categoryId) {
		
		Category category = categoryRepository.getOne(categoryId);
		
		return category.getCategoryName();
	}
	
	/**
	 * get List of Category
	 * @return List of Category
	 */
	public List<Category> getCategoryList() {
		
		// parentCategoryId of Category is 0
		List<Category> list = categoryRepository.findAll();
		
		return list;
	}
	
	/**
	 * get List of Category
	 * @param parentCategoryId parentCategoryId of SubCategory
	 * @return List of SubCategory
	 */
	public List<Category> getSubCategoryList(int parentCategoryId) {
			
		List<Category> list = categoryRepository.findByParentCategoryId(parentCategoryId);
		
		return list;
	}

}
