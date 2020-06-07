package com.fsd2020.emart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fsd2020.emart.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
    
    List<Item> findBySeller(String seller);
    
    List<Item> findByCategoryIdAndSubCategoryId(int categoryId, int subCategoryId);
    
    @Query(value = "select id,itemName,categoryId,subCategoryId,seller,price,remainNum,itemDesc from Item where itemName like CONCAT('%',:itemName,'%')")
    List<Object[]> findByItemNameLike(@Param("itemName") String itemName);
}
