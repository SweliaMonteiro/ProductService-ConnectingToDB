package com.example.services;

import com.example.models.Category;
import com.example.projections.ProductWithTitlePrice;
import com.example.models.Product;
import com.example.repositories.CategoryRepository;
import com.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service("SelfProductService")
public class SelfProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }


    @Override
    public Product getProductTitlePriceById(Long id) {
        ProductWithTitlePrice productWithTitlePrice = productRepository.getProductWithTitlePriceSQL(id);
        Product product = new Product();
        product.setTitle(productWithTitlePrice.getTitle());
        product.setPrice(productWithTitlePrice.getPrice());
        return product;
    }


    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize, String sortBy) {
        // productRepository.findAll() takes a Pageable object as an argument which will be used to specify the page number, page size, and sorting order
        return productRepository.findAll(
                // Since Pageable is an interface, we use PageRequest.of() to create an instance of PageRequest wherein Pageable is the parent of PageRequest class
                PageRequest.of(pageNumber, pageSize,
                        // Sort data by the sortBy field in ascending order and then by the title field in descending order
                        Sort.by(sortBy).ascending().and(Sort.by("title").descending())
                )
        );
    }


    @Override
    public List<Product> getAllProductsByCategory(String category) {
        Category categoryObj = categoryRepository.findCategoryByTitle(category);
        return productRepository.findAllByCategory(categoryObj);
    }


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    @Override
    public Product deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(!optionalProduct.isEmpty()) {
            productRepository.deleteById(id);
            return optionalProduct.get();
        }
        return null;
    }


    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(!optionalProduct.isEmpty()) {
            Product productToUpdate = optionalProduct.get();
            if(product.getTitle()!=null) productToUpdate.setTitle(product.getTitle());
            if(product.getDescription()!=null) productToUpdate.setDescription(product.getDescription());
            if(product.getPrice()!=0) productToUpdate.setPrice(product.getPrice());
            if(product.getImage()!=null) productToUpdate.setImage(product.getImage());
            if(product.getCategory()!=null) productToUpdate.setCategory(product.getCategory());
            productToUpdate.setId(id);
            return productRepository.save(productToUpdate);
        }
        return null;
    }


    @Override
    public Product replaceProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }
}
