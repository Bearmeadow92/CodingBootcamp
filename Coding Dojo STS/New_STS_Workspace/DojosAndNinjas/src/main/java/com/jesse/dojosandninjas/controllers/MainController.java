package com.jesse.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jesse.dojosandninjas.models.Dojo;
import com.jesse.dojosandninjas.models.Ninja;
import com.jesse.dojosandninjas.services.DojosAndNinjasServices;

@Controller
public class MainController {
	@Autowired
	private DojosAndNinjasServices dojoAndNinjaServ;
	
	
	@RequestMapping("dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo emptyDojo) {
		return "newdojo.jsp";
	}
	
	@PostMapping("dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo filledDojo, BindingResult results) {
		//VALIDATE
		if(results.hasErrors()) {
			return "newdojo.jsp";
		}
		else {
			dojoAndNinjaServ.createDojo(filledDojo);
			return "redirect:/dojos/new";
		}
	}
	
	@RequestMapping("ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja emptyNinja, Model model) {
		// GET ALL DOJOS FROM DATABASE
		List<Dojo> allDojos = dojoAndNinjaServ.getAllDojos();
		
		// PASS DOJOS TO JSP
		model.addAttribute("dojos", allDojos);
		
		return "newninja.jsp";
	}
	
	@PostMapping("ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja filledNinja, BindingResult results, Model model) {
		//VALIDATE
		if(results.hasErrors()) {
			// GET ALL DOJOS FROM DATABASE
			List<Dojo> allDojos = dojoAndNinjaServ.getAllDojos();
			
			// PASS DOJOS TO JSP
			model.addAttribute("dojos", allDojos);
			return "newninja.jsp";
		}
		else {
			dojoAndNinjaServ.createNinja(filledNinja);
			return "redirect:/ninjas/new";
		}
	}
	
	@RequestMapping("dojos/{id}")
	public String roster(@PathVariable("id") Long id, Model model) {
		//GET DOJO
		Dojo oneDojo = dojoAndNinjaServ.getOneDojo(id);
		//ADD DOJO TO MODEL
		model.addAttribute("dojo", oneDojo);
		return "showdojo.jsp";
		
	}
}