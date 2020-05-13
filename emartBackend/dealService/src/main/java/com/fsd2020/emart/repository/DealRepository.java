package com.fsd2020.emart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsd2020.emart.entity.Deal;

@Repository
public interface DealRepository extends JpaRepository<Deal, Integer>{
    
    List<Deal> findByBuyerOrderByPurchaseTimeDesc(String buyer);
    
    List<Deal> findBySellerOrderByPurchaseTimeDesc(String seller);

}
