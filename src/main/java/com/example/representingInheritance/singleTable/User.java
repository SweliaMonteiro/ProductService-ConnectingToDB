package com.example.representingInheritance.singleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "singleTable_User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue(value = "u")
public class User {

    @Id
    private int id;
    private String name;
    private String email;
    private String password;

}
