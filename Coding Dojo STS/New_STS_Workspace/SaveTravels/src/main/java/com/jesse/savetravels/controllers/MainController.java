package com.jesse.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jesse.savetravels.models.Expense;
import com.jesse.savetravels.services.SaveTravelsService;

@Controller
public class MainController {
	@Autowired
	private SaveTravelsService saveTravelsService;
	
	
	
	// READ ALL
    @GetMapping("/expenses")
    public String index(@ModelAttribute("expenses")Expense expense, Model model){
        // GET ALL EXPENSES FROM DB
        List<Expense> expenses = saveTravelsService.allExpenses();
        // PASS ALL EXPENSES TO JSP
        System.out.print(expenses);
        model.addAttribute("expense", expenses);
        return "index.jsp";
    }

    @GetMapping("/expenses/{id}/edit")
    public String edit(@PathVariable("id") Long id, Expense exp, Model model) {
        Expense findExpense = saveTravelsService.findExpense(id);
        model.addAttribute("expenses", findExpense);
        return "edit.jsp";
    }
    @PostMapping("/expenses/{id}/edit")
    public String update(@Valid @ModelAttribute("expenses") Expense exp, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	saveTravelsService.updateExpense(exp);
            return "redirect:/expenses";
        }
    }

	
    @PostMapping("/expenses")   
    public String create(@Valid @ModelAttribute("expenses") Expense expense, BindingResult result, Model model ) {
        List<Expense> expenses = saveTravelsService.allExpenses();
        // PASS ALL EXPENSES TO JSP
        model.addAttribute("expense", expenses);
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
			saveTravelsService.createExpense(expense);
            return "redirect:/expenses";
        }
    }
    
    
    @PostMapping("/expenses/{id}/delete")
	  public String destroy(@PathVariable("id") Long id) {
    	saveTravelsService.deleteExpense(id);
	  	return "redirect:/expenses";
	  }


    @GetMapping("/expenses/{id}/show")
    public String show(Model model, @PathVariable("id") Long id) {
    	Expense showExpense = saveTravelsService.findExpense(id);
    	model.addAttribute("expense", showExpense);
    	return "show.jsp";
    }



    
}

   

//@Controller
//	public class MainController {
//		@Autowired
//	SaveTravelsService saveTravelsService;
//		
//		
//		@RequestMapping("/expenses")
//		public String index(Model model) { //grabs all expenses from database
//		List<Expense> expense = saveTravelsService.allExpenses(); //
//		model.addAttribute("expenses", expense);
//		return "index.jsp";
//		}
		
		
		
		
		/*
		 * @GetMapping("/books/{id}") public String showBook(Model
		 * model, @PathVariable("id") Long id) { System.out.println(id); Book book =
		 * bookService.findBook(id); //grabs one book from database
		 * System.out.println(book);
		 * 
		 * model.addAttribute("book", book); return "show.jsp"; }
		 */
		
		
