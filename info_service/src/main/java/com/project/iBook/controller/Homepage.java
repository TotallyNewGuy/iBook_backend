package com.project.iBook.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin
public class Homepage {
    @GetMapping()
    public String helloPage() {
        return "Hello! This is our book store backend!";
    }
}
