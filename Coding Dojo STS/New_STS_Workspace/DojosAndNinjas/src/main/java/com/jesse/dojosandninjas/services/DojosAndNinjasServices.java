package com.jesse.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesse.dojosandninjas.models.Dojo;
import com.jesse.dojosandninjas.models.Ninja;
import com.jesse.dojosandninjas.repositories.DojoRepository;
import com.jesse.dojosandninjas.repositories.NinjaRepository;

@Service
public class DojosAndNinjasServices {
	// IMPORT THE TWO REPOS
	@Autowired
	private DojoRepository dojoRepo;
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	// CREATE DOJO
	public Dojo createDojo(Dojo newDojo) {
		return dojoRepo.save(newDojo);
	}
	// GET ALL DOJOS
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
	}
	// GET ONE DOJO
	public Dojo getOneDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	
	
	// CREATE A NINJA
	public Ninja createNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	// GET ALL NINJAS
	public List<Ninja> getAllNinjas(){
		return ninjaRepo.findAll();
	}
	// GET ONE NINA
	public Ninja getOneNinja(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}
	
}
