package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.ScientificField;
import com.example.repository.ScientificFieldRepository;
import com.example.service.ScientificFieldService;

@Service
public class ScientificFieldServiceImpl implements ScientificFieldService{

	@Autowired
	private ScientificFieldRepository sfRepository;
	
	@Override
	public ScientificField findByName(String name) {
		return this.sfRepository.findByName(name);
	}

}
