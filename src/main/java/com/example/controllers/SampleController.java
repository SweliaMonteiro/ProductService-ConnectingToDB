package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// SAMPLE CONTROLLER CLASS - Created to test if ProductService is running on AWS

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, this is a sample controller.";
    }


    @GetMapping("/{name}")
    public String getProductById(@PathVariable("name") String name) {
        return "Hello, " + name + "!";
    }

}
