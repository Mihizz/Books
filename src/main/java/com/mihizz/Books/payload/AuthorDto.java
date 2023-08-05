package com.mihizz.Books.payload;

import lombok.Data;

@Data
public class AuthorDto {
    private long id;
    private String name;
    private String surname;
}
