package com.shopme.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Discount;

public interface DiscountJPA extends JpaRepository<Discount, Integer>{

}
