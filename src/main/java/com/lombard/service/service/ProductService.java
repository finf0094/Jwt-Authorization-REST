package com.lombard.service.service;

import com.lombard.service.entities.Product;
import com.lombard.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void calculateAndUpdateSums() {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            // Calculate updated sums for each product
            product.calculateUpdatedSums();
        }
        // Save the updated products back to the database
        productRepository.saveAll(products);
    }
}