package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Magazine;
import com.example.repository.MagazineRepository;
import com.example.service.MagazineService;

@Service
public class MagazineServiceImpl implements MagazineService{
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	@Override
	public List<Magazine> findAll() {
		return this.magazineRepository.findAll();
	}

}
