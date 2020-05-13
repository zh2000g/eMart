package com.fsd2020.emart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fsd2020.emart.entity.Category;
import com.fsd2020.emart.service.CategoryService;


@SpringBootTest
class CategoryServiceApplicationTests {
	
    @Autowired
    private CategoryService categoryService;
    
	@Test
	void getCategoryListTest() {
		List<Category> list = categoryService.getCategoryList();
        System.out.println(String.format("getCategoryListTest test result is: %s", list.toString()));
	}
	
	@Test
	@Transactional
	void getCategoryNameTest() {
		String name = categoryService.getCategoryName(1);
		System.out.println(String.format("getCategoryNameTest test result is: %s", name));
	}
	
	@Test
	void getSubCategoryListTest() {
		List<Category> list = categoryService.getSubCategoryList(0);
        System.out.println(String.format("getSubCategoryListTest test result is: %s", list.toString()));
	}

}
