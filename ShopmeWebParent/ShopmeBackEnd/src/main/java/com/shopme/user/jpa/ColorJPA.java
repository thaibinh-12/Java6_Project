package com.shopme.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Color;

public interface ColorJPA extends JpaRepository<Color, Integer>{

}
