package com.shopme.user.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Cart_Detail;

public interface Cart_DetailJPA extends JpaRepository<Cart_Detail, Integer>{
	Optional<Cart_Detail> findByCartIdAndVariantId(int cartId, int variantId);
}
