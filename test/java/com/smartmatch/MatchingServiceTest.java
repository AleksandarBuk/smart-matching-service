package com.smartmatch;

import com.smartmatch.model.Buyer;
import com.smartmatch.model.Supplier;
import com.smartmatch.service.MatchingService;
import com.smartmatch.repository.BuyerRepository;
import com.smartmatch.repository.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MatchingServiceTest {

    @Mock
    private BuyerRepository buyerRepository;

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private MatchingService matchingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindMatchingSuppliers() {
        Buyer buyer = new Buyer();
        buyer.setId(1L);
        buyer.setIndustry("Tech");
        buyer.setRequiredProduct("Laptops");

        when(buyerRepository.findById(1L)).thenReturn(Optional.of(buyer));
        when(supplierRepository.findByIndustryAndProduct("Tech", "Laptops")).thenReturn(Collections.singletonList(new Supplier()));

        List<Supplier> suppliers = matchingService.findMatchingSuppliers(1L);
        assertFalse(suppliers.isEmpty());
    }

    @Test
    public void testFindMatchingBuyers() {
        Supplier supplier = new Supplier();
        supplier.setId(1L);
        supplier.setIndustry("Tech");
        supplier.setProduct("Laptops");

        when(supplierRepository.findById(1L)).thenReturn(Optional.of(supplier));
        when(buyerRepository.findByIndustryAndRequiredProduct("Tech", "Laptops")).thenReturn(Collections.singletonList(new Buyer()));

        List<Buyer> buyers = matchingService.findMatchingBuyers(1L);
        assertFalse(buyers.isEmpty());
    }

    @Test
    public void testFindSuppliersByIndustry() {
        when(supplierRepository.findByIndustry("Tech")).thenReturn(Collections.singletonList(new Supplier()));

        List<Supplier> suppliers = matchingService.findSuppliersByIndustry("Tech");
        assertFalse(suppliers.isEmpty());
    }

    @Test
    public void testFindBuyersByIndustry() {
        when(buyerRepository.findByIndustry("Tech")).thenReturn(Collections.singletonList(new Buyer()));

        List<Buyer> buyers = matchingService.findBuyersByIndustry("Tech");
        assertFalse(buyers.isEmpty());
    }

    @Test
    public void testFindBuyersByProduct() {
        when(buyerRepository.findByRequiredProduct("Laptops")).thenReturn(Collections.singletonList(new Buyer()));

        List<Buyer> buyers = matchingService.findBuyersByProduct("Laptops");
        assertFalse(buyers.isEmpty());
    }

    @Test
    public void testFindSuppliersByProduct() {
        when(supplierRepository.findByProduct("Laptops")).thenReturn(Collections.singletonList(new Supplier()));

        List<Supplier> suppliers = matchingService.findSuppliersByProduct("Laptops");
        assertFalse(suppliers.isEmpty());
    }

    @Test
    public void testFindMatchingSuppliersBuyerNotFound() {
        when(buyerRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            matchingService.findMatchingSuppliers(1L);
        });

        assertEquals("404 NOT_FOUND \"Buyer not found with id: 1\"", exception.getMessage());
    }

    @Test
    public void testFindMatchingBuyersSupplierNotFound() {
        when(supplierRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            matchingService.findMatchingBuyers(1L);
        });

        assertEquals("404 NOT_FOUND \"Supplier not found with id: 1\"", exception.getMessage());
    }
}
