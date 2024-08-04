package com.smartmatch.repository;

import com.smartmatch.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    List<Buyer> findByIndustry(String industry);
    List<Buyer> findByRequiredProduct(String requiredProduct);
    List<Buyer> findByIndustryAndRequiredProduct(String industry, String requiredProduct);
    Buyer findByName(String name);
}