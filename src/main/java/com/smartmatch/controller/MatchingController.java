package com.smartmatch.controller;

import com.smartmatch.model.Buyer;
import com.smartmatch.model.Supplier;
import com.smartmatch.service.MatchingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matching")
@Tag(name = "Matching", description = "Matching API")
public class MatchingController {
    private final MatchingService matchingService;

    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @GetMapping("/buyer/{buyerId}/suppliers")
    @Operation(summary = "Get matching suppliers for a buyer")
    public List<Supplier> getMatchingSuppliers(@PathVariable Long buyerId) {
        return matchingService.findMatchingSuppliers(buyerId);
    }

    @GetMapping("/supplier/{supplierId}/buyers")
    @Operation(summary = "Get matching buyers for a supplier")
    public List<Buyer> getMatchingBuyers(@PathVariable Long supplierId) {
        return matchingService.findMatchingBuyers(supplierId);
    }

    @GetMapping("/suppliers")
    @Operation(summary = "Get suppliers by industry")
    public List<Supplier> getSuppliersByIndustry(@RequestParam String industry) {
        return matchingService.findSuppliersByIndustry(industry);
    }

    @GetMapping("/buyers")
    @Operation(summary = "Get buyers by industry")
    public List<Buyer> getBuyersByIndustry(@RequestParam String industry) {
        return matchingService.findBuyersByIndustry(industry);
    }
}