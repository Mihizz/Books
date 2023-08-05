package com.mihizz.Books.service;

import com.mihizz.Books.payload.BookDto;

import java.util.List;

public interface BookService {

    BookDto createBook(BookDto bookDto);

    BookDto updateBook(long BookId, BookDto bookDto);

    void deleteBook(long BookId);

    List<BookDto> getAllBooks();

    BookDto getBookById(long BookId);
}
