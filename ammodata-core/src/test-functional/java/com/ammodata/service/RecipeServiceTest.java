package com.ammodata.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ammodata.domain.Caliber;
import com.ammodata.domain.Recipe;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config-base.xml")
@Transactional
public class RecipeServiceTest {

	@Autowired
	private RecipeService loadService;
	
	@Test
	public void testCreateRecipe()
	{
		Recipe load = new Recipe();
		Caliber caliber = new Caliber();
		load.setCaliber(caliber);
		
		loadService.createRecipe(load);
	}
	
	
}
