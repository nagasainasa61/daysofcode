package com.example.daysofcode;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HTMLController {
    @RequestMapping("/")
    public String home(){
        return "<h1>Hey this is my first day of 100 days of code</h1>";
    }
}
