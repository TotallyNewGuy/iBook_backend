package com.project.iBook.service.impl;

import com.google.gson.*;
import com.project.iBook.dao.pojo.GoogleBooks;
import com.project.iBook.service.FilterService;
import com.project.iBook.service.SearchService;
import com.project.iBook.vo.BookVo;
import com.project.iBook.vo.BooksVo;
import com.project.iBook.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import static com.project.iBook.util.PojoToVo.googleBookConvert;

@Service
public class FilterServiceImpl implements FilterService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SearchService searchService;

    // Current Best Sellers Lists
    public static final String BESTSELLER = "https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?";
//    public static final String nytKey = "api-key=J93JoV6Silz7AwQz7gbiyOYjQb1uxPA6";
    public static final String nytKey = "api-key=sUXMgOx0bPZAPRUFbx29fShC2DQkWHwl";

    // Recent books about keyword ordered from newest to oldest
    public static final String googleKey = "&key=AIzaSyDM3dFPU5K1z1Vx5ltnVKgMhzYQxvv72Io";
    public static final String googleKey2 = "&key=AIzaSyBNZz0yQjWnT1i0e4uBy-abtzfCyQQcd-8";
    public static final String googleKey3 = "&key=AIzaSyD7E9L8hJ6Zr5cmfYP3sCqKeqQPbkjWl7k";

    public static final String LIMIT = "&maxResults=";
    public static final String RECENT = "https://www.googleapis.com/books/v1/volumes?q=";
    public static final String ORDER = "&orderBy=newest";

    @Override
    public Result findTopBooks(int limit) {
        String query = BESTSELLER + nytKey;
        String jsonString = restTemplate.getForObject(query, String.class);
        if (jsonString == null || jsonString.length() == 0) {
            return Result.fail(404, "invalid parameter");
        }

        JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
        JsonArray topBooks = jsonObject.get("results").getAsJsonObject().get("books").getAsJsonArray();
        BookVo[] allBooks = new BookVo[limit];
        int index = 0;

        for (int i = 0; i < limit; i++) {
            JsonElement json = topBooks.get(i);
            JsonObject temp = json.getAsJsonObject();
            String tempString = temp.get("primary_isbn13").toString();
            int numLen = tempString.length();
            String isbn_13 = tempString.substring(1, numLen - 1);
            Result res = searchService.findByIsbn(isbn_13);
            if (!res.isSuccess()) {
                return Result.fail(500, "json parse fail");
            }
            BookVo targetBook = ((BooksVo) res.getData()).getBooks()[0];
            allBooks[index++] = targetBook;
        }
        BooksVo res = new BooksVo(allBooks);
        return Result.success(res);
    }

    @Override
    public Result findRecentBooks(int limit, String keyword) {
        String query = RECENT + keyword + ORDER + LIMIT + limit + googleKey;
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
