package com.example.daysofcode;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Contact {
    public  @Id  @GeneratedValue Long id;
    public String firstName;
    public String lastName;
    public String email;

    public Contact(){}

    public Contact(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
