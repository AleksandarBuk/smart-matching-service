package com.smartmatch.config;

import com.smartmatch.model.Buyer;
import com.smartmatch.model.Supplier;
import com.smartmatch.repository.BuyerRepository;
import com.smartmatch.repository.SupplierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(BuyerRepository buyerRepository, SupplierRepository supplierRepository) {
        return args -> {
            Buyer buyer1 = new Buyer();
            buyer1.setName("Tech Corp");
            buyer1.setIndustry("Technology");
            buyer1.setRequiredProduct("Microchips");
            buyerRepository.save(buyer1);

            Supplier supplier1 = new Supplier();
            supplier1.setName("Chip Manufacturers Inc.");
            supplier1.setIndustry("Technology");
            supplier1.setProduct("Microchips");
            supplierRepository.save(supplier1);

            Buyer buyer2 = new Buyer();
            buyer2.setName("Auto Innovators");
            buyer2.setIndustry("Automotive");
            buyer2.setRequiredProduct("Electric Motors");
            buyerRepository.save(buyer2);

            Supplier supplier2 = new Supplier();
            supplier2.setName("Motor Makers Co.");
            supplier2.setIndustry("Automotive");
            supplier2.setProduct("Electric Motors");
            supplierRepository.save(supplier2);

            Buyer buyer3 = new Buyer();
            buyer3.setName("Foodies Inc.");
            buyer3.setIndustry("Food & Beverage");
            buyer3.setRequiredProduct("Organic Ingredients");
            buyerRepository.save(buyer3);

            Supplier supplier3 = new Supplier();
            supplier3.setName("Organic Farms Ltd.");
            supplier3.setIndustry("Food & Beverage");
            supplier3.setProduct("Organic Ingredients");
            supplierRepository.save(supplier3);

            Buyer buyer4 = new Buyer();
            buyer4.setName("Furniture Masters");
            buyer4.setIndustry("Furniture");
            buyer4.setRequiredProduct("Wood Materials");
            buyerRepository.save(buyer4);

            Supplier supplier4 = new Supplier();
            supplier4.setName("Wood Suppliers LLC");
            supplier4.setIndustry("Furniture");
            supplier4.setProduct("Wood Materials");
            supplierRepository.save(supplier4);

            Buyer buyer5 = new Buyer();
            buyer5.setName("Fashion Forward");
            buyer5.setIndustry("Apparel");
            buyer5.setRequiredProduct("Textile Fabrics");
            buyerRepository.save(buyer5);

            Supplier supplier5 = new Supplier();
            supplier5.setName("Textile Producers Co.");
            supplier5.setIndustry("Apparel");
            supplier5.setProduct("Textile Fabrics");
            supplierRepository.save(supplier5);
        };
    }
}
