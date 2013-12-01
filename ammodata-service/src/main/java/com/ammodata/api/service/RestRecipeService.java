package com.ammodata.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ammodata.domain.Recipe;
import com.ammodata.service.RecipeService;


@Controller
@Transactional
public class RestRecipeService {
	@Autowired
	private RecipeService loadService;
	
	@RequestMapping(value="/load/{id}")
	@ResponseBody
	public Recipe getLoad(@PathVariable("id") Long id)
	{
		return loadService.getLoad(id);
	}
}
