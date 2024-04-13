package com.example.repositories;

import com.example.models.Product;
import com.example.projections.ProductWithTitlePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long aLong);

    @Override
    <S extends Product> S save(S entity);

    Product findProductById(Long id);

    // HQL Query
    @Query("select p.title as title, p.price as price from Product p where p.id = :id")
    ProductWithTitlePrice getProductWithTitlePriceHQL(@Param("id") Long id);

    // SQL Query
    @Query(value = "select title, price from product where id = :id", nativeQuery = true)
    ProductWithTitlePrice getProductWithTitlePriceSQL(@Param("id") Long id);

}
