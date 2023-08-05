package com.mihizz.Books.payload;

import lombok.Data;

@Data
public class BookDto {
    private long id;
    private String title;
    private int uniqueNumber;
    private String published;
    private double price;
    private int pages;
    private Boolean available;
}
