package com.fsd2020.emart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsd2020.emart.entity.CartItem;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Integer>{
    
    List<CartItem> findByBuyer(String buyer);

}
