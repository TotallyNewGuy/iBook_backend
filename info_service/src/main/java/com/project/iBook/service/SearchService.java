package com.project.iBook.service;

import com.project.iBook.vo.Result;
import org.json.simple.parser.ParseException;

public interface SearchService {

    Result findByTitle(String title) throws ParseException;

    Result findByAuthor(String author);

    Result findByIsbn(String isbn);

    Result findById(String id);

    Result findOverall(String keyword);

    Result findOverallByNum(String keyword, int number);
}
