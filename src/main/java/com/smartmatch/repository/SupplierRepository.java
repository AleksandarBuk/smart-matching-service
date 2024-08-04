package com.smartmatch.repository;

import com.smartmatch.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findByIndustry(String industry);
    List<Supplier> findByProduct(String product);
    List<Supplier> findByIndustryAndProduct(String industry, String product);
    Supplier findByName(String name);
}