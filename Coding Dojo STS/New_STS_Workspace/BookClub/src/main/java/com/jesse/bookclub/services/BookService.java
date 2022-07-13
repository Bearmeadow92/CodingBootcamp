package com.jesse.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesse.bookclub.models.Book;
import com.jesse.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	
	// CREATE / UPDATE A BOOK
	public Book save(Book bookObj) {
		return bookRepo.save(bookObj);
	}
	
	// GET ALL BOOKS
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	// GET ONE Book
	public Book getOneBook(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	// DELETE ONE Book
	public void deleteOneBook(Long id) {
		bookRepo.deleteById(id);
	}
}