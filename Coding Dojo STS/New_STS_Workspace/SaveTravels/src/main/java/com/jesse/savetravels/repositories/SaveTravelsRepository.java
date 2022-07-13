package com.jesse.savetravels.repositories;

	import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jesse.savetravels.models.Expense;

	@Repository
	public interface SaveTravelsRepository extends CrudRepository<Expense, Long>{
	    // this method retrieves all the books from the database
	    List<Expense> findAll();
//	    // this method finds books with descriptions containing the search string
//	    List<Book> findByDescriptionContaining(String search);
//	    // this method counts how many titles contain a certain string
//	    Long countByTitleContaining(String search);
//	    // this method deletes a book that starts with a specific title
//	    Long deleteByTitleStartingWith(String search);

}