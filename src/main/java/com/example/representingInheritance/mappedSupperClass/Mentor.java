package com.example.representingInheritance.mappedSupperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mappedSupperClass_Mentor")
public class Mentor extends User {

    private String company;
    private float rating;

}
