package com.ammodata.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ammodata.domain.Recipe;
import com.ammodata.service.RecipeService;

@Controller
@Transactional
public class RecipesController {
	
	
	
	@Autowired
	private RecipeService service;
	
	@ModelAttribute("recipe")
	public Recipe modelRecipe()
	{
		return new Recipe();
	}
	
	
	@RequestMapping(value="/stuff", method=RequestMethod.GET) 
	public ModelAndView getStuff() throws Exception
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("recipes", service.getRecipes());
		mv.setViewName("stuff");
		return mv;
	}
	
	@RequestMapping(value="/stuff", method=RequestMethod.POST) 
	public ModelAndView getStuff(@ModelAttribute("recipe") Recipe recipe) throws Exception
	{
		service.createRecipe(recipe);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("recipes", service.getRecipes());
		mv.setViewName("stuff");
		return mv;
	}
}
