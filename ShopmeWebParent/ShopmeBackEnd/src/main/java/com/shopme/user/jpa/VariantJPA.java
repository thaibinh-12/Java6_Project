package com.shopme.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Variant;

public interface VariantJPA extends JpaRepository<Variant, Integer>{

}
