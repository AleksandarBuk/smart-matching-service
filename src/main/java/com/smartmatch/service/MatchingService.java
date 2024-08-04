package com.smartmatch.service;

import com.smartmatch.model.Buyer;
import com.smartmatch.model.Supplier;
import com.smartmatch.repository.BuyerRepository;
import com.smartmatch.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MatchingService {
    private final BuyerRepository buyerRepository;
    private final SupplierRepository supplierRepository;

    public MatchingService(BuyerRepository buyerRepository, SupplierRepository supplierRepository) {
        this.buyerRepository = buyerRepository;
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> findMatchingSuppliers(Long buyerId) {
        Buyer buyer = buyerRepository.findById(buyerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Buyer not found with id: " + buyerId));

        return supplierRepository.findByIndustryAndProduct(buyer.getIndustry(), buyer.getRequiredProduct());
    }

    public List<Buyer> findMatchingBuyers(Long supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found with id: " + supplierId));
    
        List<Buyer> matchingBuyers = buyerRepository.findByIndustryAndRequiredProduct(supplier.getIndustry(), supplier.getProduct());
        
        return matchingBuyers;
    }

    public List<Supplier> findSuppliersByIndustry(String industry) {
        List<Supplier> suppliers = supplierRepository.findByIndustry(industry);
        if (suppliers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No suppliers found for industry: " + industry);
        }
        return suppliers;
    }

    public List<Buyer> findBuyersByIndustry(String industry) {
        List<Buyer> buyers = buyerRepository.findByIndustry(industry);
        if (buyers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No buyers found for industry: " + industry);
        }
        return buyers;
    }
}