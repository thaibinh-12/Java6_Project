package com.shopme.user.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Brand;
import com.shopme.common.entity.Product;

public interface ProductJPA extends JpaRepository<Product, Integer>{
	List<Product> findByBrand(Brand brand);

}
