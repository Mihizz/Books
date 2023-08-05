package com.mihizz.Books.service.impl;

import com.mihizz.Books.entity.Book;
import com.mihizz.Books.exception.ResourceNotFoundException;
import com.mihizz.Books.payload.BookDto;
import com.mihizz.Books.repo.BookRepo;
import com.mihizz.Books.service.BookService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {

        Book book = mapToEntity(bookDto);

        Date dateNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
        book.setCreated(ft.format(dateNow));

        Book newBook = bookRepo.save(book);

        return mapToDTO(newBook);
    }

    @Override
    public BookDto updateBook(long BookId, BookDto bookDto) {
        Book book = bookRepo.findById(BookId).orElseThrow(() -> new ResourceNotFoundException("Book","Id",BookId));

        book.setUniqueNumber(bookDto.getUniqueNumber());
        book.setPages(bookDto.getPages());
        book.setTitle(bookDto.getTitle());
        book.setAvailable(bookDto.getAvailable());
        book.setPrice(bookDto.getPrice());
        book.setPages(book.getPages());
        book.setPublished(book.getPublished());

        Book book1 = bookRepo.save(book);

        return mapToDTO(book1);
    }

    @Override
    public void deleteBook(long BookId) {
        Book book = bookRepo.findById(BookId).orElseThrow(() -> new ResourceNotFoundException("Book","Id",BookId));

        bookRepo.delete(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepo.findAll();

        return books.stream().map(book -> mapToDTO(book)).collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(long BookId) {
        Book book = bookRepo.findById(BookId).orElseThrow(() -> new ResourceNotFoundException("Book","Id",BookId));

        return mapToDTO(book);
    }

    //convert entity to DTO
    private BookDto mapToDTO(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setUniqueNumber(book.getUniqueNumber());
        bookDto.setTitle(book.getTitle());
        bookDto.setAvailable(book.getAvailable());
        bookDto.setPrice(book.getPrice());
        bookDto.setPages(book.getPages());
        bookDto.setPublished(book.getPublished());

        return bookDto;
    }

    //convert DTO to entity
    private Book mapToEntity(BookDto bookDto){
        Book book=new Book();
        book.setId(bookDto.getId());
        book.setUniqueNumber(bookDto.getUniqueNumber());
        book.setPages(bookDto.getPages());
        book.setTitle(bookDto.getTitle());
        book.setAvailable(bookDto.getAvailable());
        book.setPrice(bookDto.getPrice());
        book.setPages(book.getPages());
        book.setPublished(book.getPublished());

        return book;
    }
}
