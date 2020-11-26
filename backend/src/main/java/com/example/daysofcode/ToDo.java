package com.example.daysofcode;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ToDo {
    public  @Id  @GeneratedValue Long id;
    public String task;

    public ToDo(){}

    public ToDo(String task){
        this.task = task;
    }
}
