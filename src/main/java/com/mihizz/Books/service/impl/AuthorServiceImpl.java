package com.mihizz.Books.service.impl;

import com.mihizz.Books.entity.Author;
import com.mihizz.Books.exception.ResourceNotFoundException;
import com.mihizz.Books.payload.AuthorDto;
import com.mihizz.Books.repo.AuthorRepo;
import com.mihizz.Books.service.AuthorService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = mapToEntity(authorDto);

        Date dateNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
        author.setCreated(ft.format(dateNow));

        Author newAuthor = authorRepo.save(author);

        return mapToDTO(newAuthor);
    }

    @Override
    public AuthorDto updateAuthor(long AuthorId, AuthorDto authorDto) {
        Author author = authorRepo.findById(AuthorId).orElseThrow(() -> new ResourceNotFoundException("Author","Id",AuthorId));

        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());

        Author author1 = authorRepo.save(author);

        return mapToDTO(author1);
    }

    @Override
    public void deleteAuthor(long AuthorId) {
        Author author = authorRepo.findById(AuthorId).orElseThrow(() -> new ResourceNotFoundException("Author","Id",AuthorId));

        authorRepo.delete(author);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepo.findAll();

        return authors.stream().map(author -> mapToDTO(author)).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(long AuthorId) {
        Author author = authorRepo.findById(AuthorId).orElseThrow(() -> new ResourceNotFoundException("Author","Id",AuthorId));

        return mapToDTO(author);
    }

    private AuthorDto mapToDTO(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setSurname(author.getSurname());

        return authorDto;
    }

    //convert DTO to entity
    private Author mapToEntity(AuthorDto authorDto){
        Author author=new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());

        return author;
    }
}
