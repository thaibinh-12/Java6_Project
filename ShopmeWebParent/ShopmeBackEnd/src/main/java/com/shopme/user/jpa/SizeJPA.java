package com.shopme.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Size;

public interface SizeJPA extends JpaRepository<Size, Integer>{

}
