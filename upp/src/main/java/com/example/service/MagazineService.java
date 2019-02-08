package com.example.service;

import java.util.List;

import com.example.model.Magazine;

public interface MagazineService {
	List<Magazine> findAll();
	Magazine findOne(Long id);
}
