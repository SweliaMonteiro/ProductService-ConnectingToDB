package com.example.services;

import com.example.models.Category;
import com.example.models.Product;
import org.springframework.data.domain.Page;
import java.util.List;


public interface ProductService {

    Product getProductById(Long id);

    Product getProductTitlePriceById(Long id);

    Page<Product> getAllProducts(int pageNumber, int pageSize, String sortBy);

    List<Product> getAllProductsByCategory(String category);

    List<Category> getAllCategories();

    Product createProduct(Product product);

    Product deleteProduct(Long id);

    Product updateProduct(Long id, Product product);

    Product replaceProduct(Long id, Product product);

}
