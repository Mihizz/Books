package com.mihizz.Books.controller;

import com.mihizz.Books.payload.BookDto;
import com.mihizz.Books.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        return new ResponseEntity<>(bookService.createBook(bookDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<BookDto> getAllAuthors(){
        return  bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable(name = "id")long bookId){
        BookDto bookDto = bookService.getBookById(bookId);

        return new ResponseEntity<>(bookDto,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable(name = "id")long bookId,
                                                  @RequestBody BookDto bookDto){
        BookDto bookDto1 = bookService.updateBook(bookId, bookDto);

        return new ResponseEntity<>(bookDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable(name = "id")long bookId){
        bookService.deleteBook(bookId);

        return new ResponseEntity<>("Author successfully deleted!", HttpStatus.OK);
    }
}
