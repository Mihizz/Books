package com.mihizz.Books.controller;

import com.mihizz.Books.payload.AuthorDto;
import com.mihizz.Books.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        return new ResponseEntity<>(authorService.createAuthor(authorDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<AuthorDto> getAllAuthors(){
        return  authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "id")long authorId){
        AuthorDto authorDto = authorService.getAuthorById(authorId);

        return new ResponseEntity<>(authorDto,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable(name = "id")long authorId,
                                              @RequestBody AuthorDto authorDto){
        AuthorDto authorDto1 = authorService.updateAuthor(authorId, authorDto);

        return new ResponseEntity<>(authorDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable(name = "id")long cityId){
        authorService.deleteAuthor(cityId);

        return new ResponseEntity<>("Author successfully deleted!", HttpStatus.OK);
    }


}
