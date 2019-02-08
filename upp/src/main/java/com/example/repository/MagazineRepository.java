package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Magazine;

public interface MagazineRepository extends JpaRepository<Magazine, Long>{

    Magazine findOne(Long id);
}
