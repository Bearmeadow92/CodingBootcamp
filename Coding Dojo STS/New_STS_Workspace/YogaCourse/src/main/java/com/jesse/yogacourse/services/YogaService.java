package com.jesse.yogacourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesse.yogacourse.models.Yoga;
import com.jesse.yogacourse.repositories.YogaRepository;

@Service
public class YogaService {
	
	@Autowired
	private YogaRepository yogaRepo;
	
	
	// CREATE / UPDATE A BOOK
	public Yoga save(Yoga yogaObj) {
		return yogaRepo.save(yogaObj);
	}
	
	// GET ALL Course
	public List<Yoga> getAllYoga(){
		return yogaRepo.findAll();
	}
	
	// GET ONE Course
	public Yoga getOneYoga(Long id) {
		return yogaRepo.findById(id).orElse(null);
	}
	
	// DELETE ONE Course
	public void deleteOneYoga(Long id) {
		yogaRepo.deleteById(id);
	}
}
