package com.example.representingInheritance.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "joinedTable_User")
public class User {

    @Id
    private int id;
    private String name;
    private String email;
    private String password;

}
