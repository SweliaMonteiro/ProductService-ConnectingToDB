package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {

    private String title;

    // mappedBy is used to specify the field in the Product class that owns the relationship
    // fetch is set to FetchType.LAZY to ensure that the products are not loaded when the category is loaded
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;

}
