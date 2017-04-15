package net.toregard.service;

import net.toregard.entities.Product;
import org.springframework.stereotype.Component;

public class MapProduct {
    public Product map(String prodName,String prodDescription, double price){
        Product product =Product.builder()
                .price(price)
                .description(prodName)
                .name(prodDescription)
                .build();
        return product;
    }
}
