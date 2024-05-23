package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore  // @JsonIgnore is used to prevent the products from being serialized when the category is serialized, when products are fetched then the category is fetched which will in turn again fetch the products and this will lead to a circular reference. Hence we use @JsonIgnore to prevent this.
    private List<Product> products;

}
