package com.example;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.StorageService;

@SpringBootApplication
public class UppApplication implements CommandLineRunner{

	@Resource
	StorageService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(UppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}

}

