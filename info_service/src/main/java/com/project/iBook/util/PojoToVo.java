package com.project.iBook.util;

import com.project.iBook.dao.pojo.GoogleBooks;
import com.project.iBook.vo.BookVo;
import com.project.iBook.vo.BooksVo;
import org.springframework.beans.BeanUtils;

public class PojoToVo {

    public static BooksVo googleBookConvert(GoogleBooks googleBook) {
        int len = googleBook.getItems().length;
        BookVo[] allBooks = new BookVo[len];
        int index = 0;

        for (GoogleBooks.Items item : googleBook.getItems()) {
            BookVo bookVo = bookVoConverter(item);
            allBooks[index++] = bookVo;
        }

        BooksVo res = new BooksVo(allBooks);
        return res;
    }


    public static BookVo bookVoConverter(GoogleBooks.Items item){
        BookVo bookVo = new BookVo();
        BeanUtils.copyProperties(item.getVolumeInfo(), bookVo);

        // manually set some properties
        String isbn_10 = "";
        String isbn_13 = "";
        GoogleBooks.Items.VolumeInfo.IndustryIdentifiers[] industryIdentifiers
                = item.getVolumeInfo().getIndustryIdentifiers();
        if (industryIdentifiers != null) {
            for (int i = 0; i < industryIdentifiers.length; i++) {
                if (industryIdentifiers[i].getType().equals("ISBN_10")) {
                    isbn_10 = industryIdentifiers[i].getIdentifier();
                } else if (industryIdentifiers[i].getType().equals("ISBN_13")){
                    isbn_13 = industryIdentifiers[i].getIdentifier();
                } else {
                    bookVo.setOther_IndustryIdentifier(industryIdentifiers[i].getIdentifier());
                }
            }
        }

        bookVo.setISBN_10(isbn_10);
        bookVo.setISBN_13(isbn_13);
        bookVo.setId(item.getId());
        bookVo.setListPrice(item.getSaleInfo().getListPrice());
        if (item.getVolumeInfo().getDimensions() != null) {
            bookVo.setHeight(item.getVolumeInfo().getDimensions().getHeight());
            bookVo.setWidth(item.getVolumeInfo().getDimensions().getWidth());
            bookVo.setThickness(item.getVolumeInfo().getDimensions().getThickness());
        }

        AmazonSearch amazonSearch = new AmazonSearch();
//        if (bookVo.getListPrice() == null) {
//            double[] amazonPriceAndRating = amazonSearch.searchPrice(isbn_13);
//            double rating = amazonPriceAndRating[0];
//            double price = amazonPriceAndRating[1];
//            bookVo.setAmazonPrice(price);
//            bookVo.setAmazonRating(rating);
//        }

        double rating = 4.5;
        double price = 9.99;
        bookVo.setAmazonPrice(price);
        bookVo.setAmazonRating(rating);

        return bookVo;
    }

}
