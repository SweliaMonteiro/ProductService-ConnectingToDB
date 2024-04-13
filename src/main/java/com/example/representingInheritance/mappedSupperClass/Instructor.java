package com.example.representingInheritance.mappedSupperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mappedSupperClass_Instructor")
public class Instructor extends User {

    private String specialization;

}
