package com.example.representingInheritance.tablePerClass;

import com.example.representingInheritance.mappedSupperClass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tablePerClass_Mentor")
public class Mentor extends User {

    private String company;
    private float rating;

}
