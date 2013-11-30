package com.ammodata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ammodata.domain.Load;
import com.ammodata.repository.LoadRepository;

@Service
public class LoadService {
	
	@Autowired
	private LoadRepository loadRepository;
	
	public Load getLoad(Long id) 
	{	
		return loadRepository.read(id);
	}

	public void createLoad(Load load) {
		loadRepository.create(load);
	}
}
