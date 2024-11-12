package com.shopme.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Order;

public interface OrderJPA extends JpaRepository<Order, Integer>{

}
