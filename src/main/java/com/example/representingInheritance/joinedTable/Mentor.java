package com.example.representingInheritance.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "joinedTable_Mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User {

    private String company;
    private float rating;

}
