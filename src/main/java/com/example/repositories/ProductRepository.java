package com.example.repositories;

import com.example.models.Category;
import com.example.models.Product;
import com.example.projections.ProductWithTitlePrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long aLong);

    // The findAll method returns a Page object that contains a list of products
    // It takes a Pageable object as an argument which will be used to specify the page number, page size, and sorting order
    @Override
    Page<Product> findAll(Pageable pageable);

    List<Product> findAllByCategory(Category category);

    @Override
    <S extends Product> S save(S entity);

    @Override
    void deleteById(Long aLong);


    // HQL Query (Hibernate Query Language) - is a platform-independent object-oriented query language defined
    // as part of the JPA specification that allows you to define database queries based on your entity model
    @Query("select p.title as title, p.price as price from Product p where p.id = :id")
    ProductWithTitlePrice getProductWithTitlePriceHQL(@Param("id") Long id);

    // SQL Query (Structured Query Language) - is a query language used to communicate with the database
    // It is used to perform operations on the records stored in the database
    @Query(value = "select title, price from product where id = :id", nativeQuery = true)
    ProductWithTitlePrice getProductWithTitlePriceSQL(@Param("id") Long id);

}
