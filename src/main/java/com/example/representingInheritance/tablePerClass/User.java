package com.example.representingInheritance.tablePerClass;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "tablePerClass_User")
public class User {

    @Id
    private int id;
    private String name;
    private String email;
    private String password;

}
