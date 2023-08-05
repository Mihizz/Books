package com.mihizz.Books.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Books", uniqueConstraints = {@UniqueConstraint(columnNames = {"uniqueNumber"})})
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @Column(
            name = "title",nullable = false
    )
    private String title;

    @Column(
            name = "uniqueNumber", nullable = false
    )
    private int uniqueNumber;

    @Column(
            name = "numberOfPages"
    )
    private int pages;

    @Column(
            name = "price"
    )
    private double price;

    @Column(
            name = "availableInStores", nullable = false
    )
    private Boolean available;

    @Column(
            name = "publishedDate"
    )
    private String published;

    @Column(
            name = "created", nullable = false
    )
    private String created;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id")
    )
    private Set<Author> authors;
}
