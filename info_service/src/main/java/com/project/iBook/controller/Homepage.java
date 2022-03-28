package com.project.iBook.controller;

import com.project.iBook.service.FilterService;
import com.project.iBook.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
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
