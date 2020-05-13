package com.fsd2020.emart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsd2020.emart.entity.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, String>{
    List<Buyer> findByUserId(String UserId);
    
    
}
