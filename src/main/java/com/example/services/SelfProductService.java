package com.example.services;

import com.example.projections.ProductWithTitlePrice;
import com.example.models.Product;
import com.example.repositories.CategoryRepository;
import com.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("SelfProductService")
public class SelfProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Product getProductById(Long id) {
        ProductWithTitlePrice productWithTitlePrice = productRepository.getProductWithTitlePriceSQL(id);
        Product product = new Product();
        product.setTitle(productWithTitlePrice.getTitle());
        product.setPrice(productWithTitlePrice.getPrice());
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        if(product.getCategory().getId() == null) {
            product.setCategory(categoryRepository.save(product.getCategory()));
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

}
