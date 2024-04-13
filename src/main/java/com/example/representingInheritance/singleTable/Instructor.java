package com.example.representingInheritance.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value = "i")
@Entity
public class Instructor extends User {

    private String specialization;

}
