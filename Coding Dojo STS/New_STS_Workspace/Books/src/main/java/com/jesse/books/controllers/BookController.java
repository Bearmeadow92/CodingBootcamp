package com.jesse.books.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jesse.books.models.BookModel;
import com.jesse.books.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	public BookController(BookService bookService) {
        this.bookService = bookService;
    }
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<BookModel> book = bookService.allBooks(); //grabs all books from database
		model.addAttribute("books", book);
		return "index.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String showBook(Model model, @PathVariable("id") Long id) {
		System.out.println(id);
		BookModel book = bookService.findBook(id); //grabs one book from database
		System.out.println(book); 

		model.addAttribute("book", book);
		return "show.jsp";
}
	
	
	
	
	
}
