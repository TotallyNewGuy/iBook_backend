package com.project.iBook.controller;

import com.project.iBook.service.FilterService;
import com.project.iBook.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/books", method = RequestMethod.GET)
public class FilterController {

    // get up to 10 books
    static int LIMIT = 10;

    @Autowired
    private FilterService filterService;

    @GetMapping("/top")
    public Result findTopBooks() {
        return filterService.findTopBooks(LIMIT);
    }

    @GetMapping("/recent/{keyword}")
    public Result findRecentBooks(@PathVariable("keyword") String keyword) {
        return filterService.findRecentBooks(LIMIT, keyword);
    }
}
