package com.mihizz.Books.repo;

import com.mihizz.Books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
