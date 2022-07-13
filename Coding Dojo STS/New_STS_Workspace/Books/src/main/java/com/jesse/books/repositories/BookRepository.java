package com.jesse.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jesse.books.models.BookModel;

@Repository
public interface BookRepository extends CrudRepository<BookModel, Long>{
    // this method retrieves all the books from the database
    List<BookModel> findAll();
    // this method finds books with descriptions containing the search string
    List<BookModel> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
}