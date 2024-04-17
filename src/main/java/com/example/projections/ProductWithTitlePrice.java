package com.example.projections;

// Projection interface to get product title and price from the database
public interface ProductWithTitlePrice {

    String getTitle();

    Double getPrice();

}
