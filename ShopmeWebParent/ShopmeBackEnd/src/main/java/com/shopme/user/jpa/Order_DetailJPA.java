package com.shopme.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Order_Detail;

public interface Order_DetailJPA extends JpaRepository<Order_Detail, Integer>{

}
