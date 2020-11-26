package com.example.daysofcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ToDoLoader implements CommandLineRunner {
    private final ToDoRepository repository;

    @Autowired
    public ToDoLoader(ToDoRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception{
        this.repository.save(new ToDo("pack you bags"));
    }
}
