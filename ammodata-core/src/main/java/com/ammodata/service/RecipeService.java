package com.ammodata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ammodata.domain.Recipe;
import com.ammodata.repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository loadRepository;
	
	public Recipe getLoad(Long id) 
	{	
		return loadRepository.read(id);
	}

	public void createLoad(Recipe load) {
		loadRepository.create(load);
	}
}
