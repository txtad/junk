package com.ammodata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ammodata.domain.Recipe;
import com.ammodata.repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository loadRepository;
	
	public Recipe getRecipe(Long id) 
	{	
		return loadRepository.read(id);
	}

	public List <Recipe> getRecipes() throws Exception {
		return loadRepository.readAll();
	}

	public Long createRecipe(Recipe load) {
		return loadRepository.create(load).getRecipeID();
	}

}
