package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.CascadeType;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String title;

    private String description;

    private double price;

    private String image;

    // Cascade type is set to PERSIST to ensure that when a new product is created, the category is also created
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

}
