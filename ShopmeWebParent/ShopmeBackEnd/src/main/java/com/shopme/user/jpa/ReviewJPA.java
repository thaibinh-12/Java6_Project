package com.shopme.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Review;

public interface ReviewJPA extends JpaRepository<Review, Integer>{

}
