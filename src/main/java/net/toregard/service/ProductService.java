package net.toregard.service;

import net.toregard.entities.Product;

public interface ProductService {
    Product createProduct(String prodName, String prodDescription, double price);
}
