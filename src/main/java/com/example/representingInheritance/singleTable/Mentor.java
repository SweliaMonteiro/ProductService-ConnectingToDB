package com.example.representingInheritance.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value = "m")
@Entity
public class Mentor extends User {

    private String company;
    private float rating;

}
