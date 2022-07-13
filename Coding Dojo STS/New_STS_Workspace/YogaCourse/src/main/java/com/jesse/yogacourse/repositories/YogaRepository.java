package com.jesse.yogacourse.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jesse.yogacourse.models.Yoga;

@Repository
public interface YogaRepository extends CrudRepository<Yoga, Long> {
  	List<Yoga> findAll();
	  }

	
	
	