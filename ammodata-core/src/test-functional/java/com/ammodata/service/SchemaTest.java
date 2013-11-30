package com.ammodata.service;

import org.hibernate.SessionFactory;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ammodata.domain.Caliber;
import com.ammodata.domain.Load;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config-base.xml")
public class SchemaTest {

	@Autowired
	private LocalSessionFactoryBean sessionFactory;
	
	@Test
	public void testGetLoad()
	{
		SchemaExport export = new SchemaExport(((LocalSessionFactoryBean)sessionFactory).getConfiguration());
		export.setDelimiter(";");
		export.create(true, false);
	}
	
	
}
