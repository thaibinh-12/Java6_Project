package com.shopme.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Type;

public interface TypeJPA extends JpaRepository<Type, Integer>{
	Type findByName(String name); 
}
