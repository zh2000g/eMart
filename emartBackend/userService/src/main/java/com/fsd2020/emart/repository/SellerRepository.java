package com.fsd2020.emart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsd2020.emart.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, String>{
    List<Seller> findByUserId(String UserId);    
}
