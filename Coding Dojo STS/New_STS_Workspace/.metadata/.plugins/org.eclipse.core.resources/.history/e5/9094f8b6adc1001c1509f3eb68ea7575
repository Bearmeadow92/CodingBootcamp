package com.jesse.yogacourse.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jesse.yogacourse.models.User;
import com.jesse.yogacourse.models.Yoga;
import com.jesse.yogacourse.services.UserService;
import com.jesse.yogacourse.services.YogaService;

@Controller
public class YogaController {
	@Autowired
	private YogaService yogaServ;
	
	@Autowired
	private UserService userServ;
	
	
	// ---------------- CREATE ------------------//
	@GetMapping("/classes/new")
	public String newYoga(
			HttpSession session,
			@ModelAttribute("yogaObj") Yoga emptyYoga
			
	) {
		// CHECK TO SEE IF USER IS LOGGED IN
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		return "newcourse.jsp";
	}
	
	@PostMapping("/classes/new")
	public String createBook(
			@Valid @ModelAttribute("yogaObj") Yoga filledYoga,
			BindingResult results
	) {
		// CHECK FOR VALIDATIONS
		if(results.hasErrors()) {
			// VALIDATIONS FAILED
			return "newcourse.jsp";
		}
		else {
			// VALIDATIONS PASSED
			yogaServ.save(filledYoga);
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
		
		// RETRIEVE ALL Classes
		List<Yoga> allYoga = yogaServ.getAllYoga();
		
		model.addAttribute("user", loggedUser);
		model.addAttribute("yoga", allYoga);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/classes/{id}")
	public String oneBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		// CHECK TO SEE IF USER IS LOGGED IN
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		
		// GET ONE class
		Yoga oneYoga = yogaServ.getOneYoga(id);
		Long user_id = (Long) session.getAttribute("user_id");
		User loggedUser = userServ.getOneUser(user_id);
		model.addAttribute("yoga", oneYoga);
		model.addAttribute("user", loggedUser);
		return "showcourse.jsp";
	}
	
	// ---------------- READ --------------------//
	
	// ---------------- UPDATE --------------------//
	@GetMapping("/classes/edit/{id}")
	public String editYoga(@PathVariable("id")Long id, Model model, HttpSession session) {
		// CHECK TO SEE IF USER IS LOGGED IN
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		// GET ONE BOOK
		Yoga oneYoga = yogaServ.getOneYoga(id);
		
		model.addAttribute("yogaObj", oneYoga);
		
		return "editcourse.jsp";
	}
	
	@PutMapping("/classes/edit/{id}")
	public String updateYoga(
			@Valid @ModelAttribute("yogaObj") Yoga filledYoga,
			BindingResult results
	) {
		// CHECK FOR VALIDATIONS
		if(results.hasErrors()) {
			// VALIDATIONS FAILED
			return "editcourse.jsp";
		}
		else {
			// VALIDATIONS PASSED
			yogaServ.save(filledYoga);
			return "redirect:/dashboard";
		}
	}
	
	
	// ---------------- UPDATE --------------------//
	
	// ---------------- DELETE --------------------//
	@DeleteMapping("/classes/delete/{id}")
	public String deleteYoga(@PathVariable("id")Long id) {
		yogaServ.deleteOneYoga(id);
		return "redirect:/dashboard";
	}
	// ---------------- DELETE --------------------//
	
}
 
