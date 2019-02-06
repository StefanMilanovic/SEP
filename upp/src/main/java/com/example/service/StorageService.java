package com.example.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

public interface StorageService {
	
	public void store (MultipartFile file);
	public Resource loadFile(String filename);
	public void deleteAll();
	public void init();

}
