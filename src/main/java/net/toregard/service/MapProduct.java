package net.toregard.service;

import net.toregard.entities.Product;
import org.springframework.stereotype.Component;

public class MapProduct {
    public Product map(String prodName,String prodDescription, double price){
        Product product =Product.builder()
                .price(100.0)
                .prodDescription("ProductA")
                .prodId(1L)
                .prodName("ProductNameA")
                .build();
        return product;
    }
}
