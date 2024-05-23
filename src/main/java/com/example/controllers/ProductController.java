package com.example.controllers;

import com.example.models.Category;
import com.example.services.ProductService;
import com.example.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    // @Autowired is used to inject the ProductService bean into the ProductController class
    // @Qualifier is used to specify the name of the ProductService bean to be injected
    @Autowired
    @Qualifier("SelfProductService") private ProductService productService;


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }


    @GetMapping("/{id}/title-price")
    public Product getProductTitlePriceById(@PathVariable("id") Long id) {
        return productService.getProductTitlePriceById(id);
    }


    // API request : http://localhost:8181/products?pageNumber=1&pageSize=3&sortBy=title
    // The getAllProducts method takes three parameters: pageNumber, pageSize, and sortBy from the API request. If these parameters are not provided, the default values are used.
    @GetMapping()
    public Page<Product> getAllProducts(@RequestParam(value="pageNumber", defaultValue="0") int pageNumber,
                                        @RequestParam(value="pageSize", defaultValue="2") int pageSize,
                                        @RequestParam(value="sortBy", defaultValue="id") String sortBy) {
        return productService.getAllProducts(pageNumber, pageSize, sortBy);
    }


    @GetMapping("/categories/{category}")
    public List<Product> getAllProductsByCategory(@PathVariable("category") String category) {
        return productService.getAllProductsByCategory(category);
    }


    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return productService.getAllCategories();
    }


    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }


    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }


    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }
}
