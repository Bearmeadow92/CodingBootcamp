
  package com.jesse.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jesse.bookclub.models.Book;
import com.jesse.bookclub.models.User;
import com.jesse.bookclub.services.BookService;
import com.jesse.bookclub.services.UserService;

@Controller
public class BookController {
	@Autowired
	private BookService bookServ;
	
	@Autowired
	private UserService userServ;
	
	
	// ---------------- CREATE ------------------//
	@GetMapping("/books/new")
	public String newBook(
			HttpSession session,
			@ModelAttribute("bookObj") Book emptyBook
			
	) {
		// CHECK TO SEE IF USER IS LOGGED IN
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		return "newbook.jsp";
	}
	
	@PostMapping("/books/new")
	public String createBook(
			@Valid @ModelAttribute("bookObj") Book filledBook,
			BindingResult results
	) {
		// CHECK FOR VALIDATIONS
		if(results.hasErrors()) {
			// VALIDATIONS FAILED
			return "newbook.jsp";
		}
		else {
			// VALIDATIONS PASSED
			bookServ.save(filledBook);
			return "redirect:/dashboard";
		}
	}
	
	// ---------------- CREATE ------------------//
	
	
	
	// ---------------- READ --------------------//
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		// CHECK TO SEE IF USER IS LOGGED IN
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		// RETRIEVE USER
		Long user_id = (Long) session.getAttribute("user_id");
		User loggedUser = userServ.getOneUser(user_id);
		
		// RETRIEVE ALL Books
		List<Book> allBooks = bookServ.getAllBooks();
		
		model.addAttribute("user", loggedUser);
		model.addAttribute("books", allBooks);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String oneBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		// CHECK TO SEE IF USER IS LOGGED IN
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		
		// GET ONE BOOK
		Book oneBook = bookServ.getOneBook(id);
		Long user_id = (Long) session.getAttribute("user_id");
		User loggedUser = userServ.getOneUser(user_id);
		model.addAttribute("book", oneBook);
		model.addAttribute("user", loggedUser);
		return "showbook.jsp";
	}
	
	// ---------------- READ --------------------//
	
	// ---------------- UPDATE --------------------//
	@GetMapping("/books/edit/{id}")
	public String editRecipe(@PathVariable("id")Long id, Model model, HttpSession session) {
		// CHECK TO SEE IF USER IS LOGGED IN
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		// GET ONE BOOK
		Book oneBook = bookServ.getOneBook(id);
		
		model.addAttribute("bookObj", oneBook);
		
		return "editbook.jsp";
	}
	
	@PutMapping("/books/edit/{id}")
	public String updateBook(
			@Valid @ModelAttribute("bookObj") Book filledBook,
			BindingResult results
	) {
		// CHECK FOR VALIDATIONS
		if(results.hasErrors()) {
			// VALIDATIONS FAILED
			return "editbook.jsp";
		}
		else {
			// VALIDATIONS PASSED
			bookServ.save(filledBook);
			return "redirect:/dashboard";
		}
	}
	
	
	// ---------------- UPDATE --------------------//
	
	// ---------------- DELETE --------------------//
	@GetMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id")Long id) {
		bookServ.deleteOneBook(id);
		return "redirect:/dashboard";
	}
	// ---------------- DELETE --------------------//
	
}
 
