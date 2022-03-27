package com.project.iBook.controller;

import com.project.iBook.service.SearchService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.iBook.vo.Result;

@RestController
@RequestMapping(value = "/api/books/search", method = RequestMethod.GET)
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("{keyword}")
    public Result searchBooksByKeyword(@PathVariable("keyword") String keyword) {
        return searchService.findOverall(keyword);
    }

    @GetMapping("title/{title}")
    public Result searchBooksByTitle(@PathVariable("title") String title) throws ParseException {
        return searchService.findByTitle(title);
    }

    @GetMapping("author/{author}")
    public Result searchBooksByAuthor(@PathVariable("author") String author) {
        return searchService.findByAuthor(author);
    }

    @GetMapping("isbn/{isbn}")
    public Result searchBooksByIsbn(@PathVariable("isbn") String isbn) {
        return searchService.findByIsbn(isbn);
    }

    @GetMapping("id/{bookId}")
    public Result searchBooksById(@PathVariable("bookId") String id) {
        return searchService.findById(id);
    }
}
