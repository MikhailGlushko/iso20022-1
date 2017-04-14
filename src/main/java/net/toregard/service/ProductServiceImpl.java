package net.toregard.service;

import net.toregard.entities.Product;
import net.toregard.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    private MapProduct map=new MapProduct();

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(String prodName, String prodDescription, double price) {
        Product product =map.map(prodName,prodDescription,price);
        product.setUpdatedTime(LocalDateTime.now());
        return this.productRepository.saveAndFlush(product);
    }


}
