package com.project.iBook.vo;

import com.project.iBook.dao.pojo.GoogleBooks;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookVo {
    private String id;
    private String title;
    private String[] authors;
    private String publisher;
    private String publishedDate;
    private String description;
    private String mainCategory;
    private String height;
    private String width;
    private String thickness;
    private String ISBN_10;
    private String ISBN_13;
    private String Other_IndustryIdentifier;
    private Integer pageCount;
    private Double averageRating;
    private Double ratingsCount;
    private GoogleBooks.Items.VolumeInfo.ImageLinks imageLinks;
    private GoogleBooks.Items.SaleInfo.ListPrice listPrice;
    private Double amazonPrice;
}
