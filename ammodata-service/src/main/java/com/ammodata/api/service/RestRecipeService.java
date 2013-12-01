package com.ammodata.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ammodata.domain.Recipe;
import com.ammodata.service.RecipeService;


@Controller
@Transactional
public class RestRecipeService {
	@Autowired
	private RecipeService loadService;
	
	@RequestMapping(value="/loads", method=RequestMethod.GET)
	@ResponseBody
	public List <Recipe> getLoads() throws Exception
	{
		return loadService.getRecipes();
	}

	@RequestMapping(value="/load/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Recipe getLoad(@PathVariable("id") Long id) throws Exception
	{
		return loadService.getRecipe(id);
	}
	
	@RequestMapping(value="/loads", method=RequestMethod.POST) 
	@ResponseBody
	public void postLoad(@RequestBody Recipe recipe) throws Exception
	{
		loadService.createRecipe(recipe);
	}

	
}
