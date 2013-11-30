package com.ammodata.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ammodata.domain.Caliber;
import com.ammodata.domain.Load;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config-base.xml")
@Transactional
public class LoadServiceTest {

	@Autowired
	private LoadService loadService;
	
	@Test
	@Rollback(false)
	public void testGetLoad()
	{
		Load load = new Load();
		Caliber caliber = new Caliber();
		load.setCaliber(caliber);
		
		loadService.createLoad(load);
	}
	
	
}
