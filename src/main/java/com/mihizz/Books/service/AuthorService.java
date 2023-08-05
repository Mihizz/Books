package com.mihizz.Books.service;

import com.mihizz.Books.payload.AuthorDto;
import com.mihizz.Books.payload.BookDto;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);

    AuthorDto updateAuthor(long AuthorId, AuthorDto authorDto);

    void deleteAuthor(long AuthorId);

    List<AuthorDto> getAllAuthors();

    AuthorDto getAuthorById(long AuthorId);
}
