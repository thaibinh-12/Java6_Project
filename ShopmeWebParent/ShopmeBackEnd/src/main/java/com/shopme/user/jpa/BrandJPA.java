package com.shopme.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Brand;


public interface BrandJPA extends JpaRepository<Brand, Integer>{
	Brand findByName(String name); 
}
