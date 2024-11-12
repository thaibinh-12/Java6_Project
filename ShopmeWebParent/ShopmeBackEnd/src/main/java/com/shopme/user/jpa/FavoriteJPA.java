package com.shopme.user.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Favorite;

public interface FavoriteJPA extends JpaRepository<Favorite, Integer>{
	boolean existsByUserIdAndProductId(int accountId, int productId);
	
	void deleteByUserIdAndProductId(int accountId, int productId);
	
	List<Favorite> findByAccountId(int acccountId);
}
