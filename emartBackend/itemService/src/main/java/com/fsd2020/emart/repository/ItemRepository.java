package com.fsd2020.emart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsd2020.emart.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
    
    List<Item> findBySeller(String seller);
    
    List<Item> findByCategoryIdAndSubCategoryId(int categoryId, int subCategoryId);
    
    List<Item> findByItemName(String itemName);
}
