package com.jesse.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jesse.dojosandninjas.models.Ninja;

	@Repository	public interface NinjaRepository extends CrudRepository<Ninja,Long> {
		List<Ninja> findAll();
	}
