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

    public static final int limit = 20;

    public static final String googleKey = "&key=AIzaSyDM3dFPU5K1z1Vx5ltnVKgMhzYQxvv72Io";
    public static final String googleKey2 = "&key=AIzaSyBNZz0yQjWnT1i0e4uBy-abtzfCyQQcd-8";
    public static final String googleKey3 = "&key=AIzaSyD7E9L8hJ6Zr5cmfYP3sCqKeqQPbkjWl7k";
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
    public Result findOverallByNum(String keyword, int number) {
        String customLimit = "&maxResults=" + number;
        String query = ADDRESS + keyword + customLimit + googleKey;
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
        String jsonString = "";
        try {
            jsonString = restTemplate.getForObject(query, String.class);
        } catch (Exception e) {
            return Result.fail(404, "Request uri is invalid");
        }

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
        if (errorMsg.equals(jsonString)) {
            return Result.fail(404, "Request uri is invalid");
        }
        Gson gson = new Gson();
        GoogleBooks googleBook = gson.fromJson(jsonString, GoogleBooks.class);
        if (googleBook != null) {
            BooksVo booksVo = googleBookConvert(googleBook);
            return Result.success(booksVo);
        }
        return Result.fail(500, "json parse fail");
    }

    private static final String errorMsg = "{\n" +
            "  \"kind\": \"books#volumes\",\n" +
            "  \"totalItems\": 0\n" +
            "}\n";
}
