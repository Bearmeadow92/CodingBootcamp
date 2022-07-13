package com.jesse.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesse.savetravels.models.Expense;
import com.jesse.savetravels.repositories.SaveTravelsRepository;

@Service
	
	public class SaveTravelsService {
	 // adding the expense repository as a dependency
	@Autowired
	 private SaveTravelsRepository saveTravelsRepository;
	 
	 // returns all the expenses
	 public List<Expense> allExpenses() {
	     return saveTravelsRepository.findAll();
	 }
	 // creates an expense
	 public Expense createExpense(Expense e) {
	     return saveTravelsRepository.save(e);
	 }
	 // retrieves an expense
	 public Expense findExpense(Long id) {
		 Optional<Expense> optionalExpense = saveTravelsRepository.findById(id);
		 if(optionalExpense.isPresent()) {
			 return optionalExpense.get();
		 } else {
			 return null;
		 }
					 
	 }
	 
		public Expense updateExpense(Expense expense) {
			return saveTravelsRepository.save(expense);
		}
		
		
		public void deleteExpense(Long id) {
			saveTravelsRepository.deleteById(id);
		}
	}
