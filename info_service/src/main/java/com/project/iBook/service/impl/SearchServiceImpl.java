package com.project.iBook.service.impl;

import com.google.gson.Gson;
import com.project.iBook.dao.pojo.GoogleBooks;
import com.project.iBook.service.SearchService;
import com.project.iBook.vo.BookVo;
import com.project.iBook.vo.BooksVo;
import com.project.iBook.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.project.iBook.util.PojoToVo.bookVoConverter;
import static com.project.iBook.util.PojoToVo.googleBookConvert;

@Service

public class SearchServiceImpl implements SearchService {

    public static final int limit = 5;

    public static final String googleKey = "&key=AIzaSyCJikaJ1oRTAiy0oc3PM6qzqRpSLPGw7CE";
    public static final String LIMIT = "&maxResults=" + limit;

    public static final String ADDRESS = "https://www.googleapis.com/books/v1/volumes?q=";
    public static final String FindByIdAddress = "https://www.googleapis.com/books/v1/volumes/";

    public static final String TITLE = "intitle:";
    public static final String AUTHOR = "inauthor:";
    public static final String ISBN = "isbn:";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Result findOverall(String keyword) {
        String query = ADDRESS + keyword + LIMIT + googleKey;
        String jsonString = restTemplate.getForObject(query, String.class);

        Gson gson = new Gson();
        GoogleBooks googleBook = gson.fromJson(jsonString, GoogleBooks.class);

        if (googleBook != null) {
            BooksVo booksVo = googleBookConvert(googleBook);
            return Result.success(booksVo);
        }
        return Result.fail(500, "json parse fail");
    }

    @Override
    public Result findById(String id) {
        String query = FindByIdAddress + id;
//        String query = FindByIdAddress + id + googleKey;
        String jsonString = restTemplate.getForObject(query, String.class);

        Gson gson = new Gson();
        GoogleBooks.Items book = gson.fromJson(jsonString, GoogleBooks.Items.class);

        if (book != null) {
            BookVo bookVo = bookVoConverter(book);
            return Result.success(bookVo);
        }

        return Result.fail(500, "json parse fail");
    }

    @Override
    public Result findByTitle(String title) {
        return getResult(TITLE, title);
    }

    @Override
    public Result findByAuthor(String author) {
        return getResult(AUTHOR, author);
    }

    @Override
    public Result findByIsbn(String isbn) {
        return getResult(ISBN, isbn);
    }

    private Result getResult(String search, String term) {
        String query = ADDRESS + search + term + LIMIT + googleKey;
        String jsonString = restTemplate.getForObject(query, String.class);

        Gson gson = new Gson();
        GoogleBooks googleBook = gson.fromJson(jsonString, GoogleBooks.class);

        if (googleBook != null) {
            BooksVo booksVo = googleBookConvert(googleBook);
            return Result.success(booksVo);
        }

        return Result.fail(500, "json parse fail");
    }

}